package csust.imageSearch.model;

public class ImageInfo {
	private float score;
	private String url;
	private String title;
	private String homeUrl;

	public ImageInfo() {

	}


	public ImageInfo(float score, String url, String title, String homeUrl) {
		super();
		this.score = score;
		this.url = url;
		this.title = title;
		this.homeUrl = homeUrl;
	}


	
	
	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getHomeUrl() {
		return homeUrl;
	}


	public void setHomeUrl(String homeUrl) {
		this.homeUrl = homeUrl;
	}


	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	@Override
	public String toString() {
		return "ImageInfo [score=" + score + ", url=" + url + ", title="
				+ title + ", homeUrl=" + homeUrl + "]";
	}

	

	
	
	
}
