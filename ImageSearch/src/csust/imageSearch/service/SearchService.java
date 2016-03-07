package csust.imageSearch.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import net.semanticmetadata.lire.DocumentBuilder;
import net.semanticmetadata.lire.ImageSearchHits;
import net.semanticmetadata.lire.ImageSearcher;
import net.semanticmetadata.lire.ImageSearcherFactory;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.store.FSDirectory;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import csust.imageSearch.model.ImageInfo;
import csust.imageSearch.orm.IndexLocation;
import csust.imageSearch.orm.dao.impl.IndexLocationDaoImpl;
import csust.imageSearch.orm.dao.impl.PictureDaoImpl;

public class SearchService extends ActionSupport implements ServletRequestAware{

	private String url;
	private File file;
	private String fileFileName;
	private String fileContentType;
	

	private IndexLocationDaoImpl ildi;
	private PictureDaoImpl pdi;
	
	private HttpServletRequest request;

	
	
	public PictureDaoImpl getPdi() {
		return pdi;
	}

	public void setPdi(PictureDaoImpl pdi) {
		this.pdi = pdi;
	}

	public IndexLocationDaoImpl getIldi() {
		return ildi;
	}

	public void setIldi(IndexLocationDaoImpl ildi) {
		this.ildi = ildi;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	@SuppressWarnings("resource")
	public String upload() throws Exception{
		List<ImageInfo> imageInfos = new ArrayList<ImageInfo>();
		IndexLocation indexLocation = ildi.getRootLocation(1);
		String cacheName;
		InputStream inStream;
		if (file == null) {
			// 用链接来搜图的
			String[] pic = url.split("\\.");
			
			System.out.println();
			cacheName = System.currentTimeMillis() + "." + pic[pic.length-1];

			try {
				java.net.URL givenUrl = new java.net.URL(url);
				java.net.HttpURLConnection conn = (java.net.HttpURLConnection) givenUrl
						.openConnection();
				conn.setRequestMethod("GET");
				conn.setConnectTimeout(5 * 1000);
				inStream = conn.getInputStream();// 通过输入流获取图片数据
			} catch (Exception e) {
				return "linkError";
			}

			// 检索过程，通过检索而得到目标的文件地址list，方法来通用实现！
			//保存图片到本地
			
			OutputStream os = new FileOutputStream(new File(ildi.getRootLocation(3).getValue(),cacheName));
			byte[] buf = new byte[10240];
			int length = 0;
			while(-1 != (length = inStream.read(buf))){
				os.write(buf,0,length);
			}
			os.close();
			
		} else {
			
		
			//1452166113700.image/jpeg
			cacheName = System.currentTimeMillis() + "." + this.fileContentType.substring(6);
			// 用上传文件的方式来搜索的
			try {
				inStream = new FileInputStream(file);
				//保存图片到本地
				OutputStream os = new FileOutputStream(new File(ildi.getRootLocation(3).getValue(),cacheName));
				byte[] buf = new byte[1024];
				int length = 0;
				while(-1 != (length = inStream.read(buf))){
					os.write(buf,0,length);
				}
				os.close();
			} catch (Exception e) {
				return "fileError";
			}

		}

		System.out.println("000");
		IndexReader ir = IndexReader.open(FSDirectory.open(new File(indexLocation.getValue())));
        ImageSearcher is = ImageSearcherFactory.createJCDImageSearcher(10000);
        //FileInputStream fis = new FileInputStream();

        BufferedImage bi;
        if(file == null){
        	bi = ImageIO.read(new java.net.URL(url));
        	 request.setAttribute("rootPicture", url);
        }else{
        	bi = ImageIO.read(file);
        	//D:\\cache
        	String str = ildi.getRootLocation(3).getValue().toString();
        	String strimg = str.substring(0,2) + "\\" + str.substring(4);
        	System.out.println("980930129739812791##"+strimg + "\\" + cacheName);
        	request.setAttribute("rootPicture", strimg + "\\" + cacheName);
        }
       // BufferedImage bi = ImageIO.read(new java.net.URL(url));
        ImageSearchHits ish = is.search(bi, ir);
        for (int i = 0; i < ish.length(); i++) {
        	String str = ish.doc(i).getFieldable(DocumentBuilder.FIELD_NAME_IDENTIFIER).stringValue();
        	ImageInfo imgImageInfo = new ImageInfo();
        	imgImageInfo.setScore(ish.score(i));
        	imgImageInfo.setUrl(str);
        	imgImageInfo.setTitle(pdi.getPictueByName(str).getDescription());
        	imgImageInfo.setHomeUrl(pdi.getPictueByName(str).getObjurl());
        	imageInfos.add(imgImageInfo);
            System.out.println(ish.score(i) + ": " + str);
        }
        request.setAttribute("imageInfos", imageInfos);
       
       
       
		return "success";
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

}
