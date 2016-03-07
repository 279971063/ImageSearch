package test;

public class Test {

	public static void main(String[] args) {
		String url = "d:\\welk";
		String url1 = url.substring(0, 2);
		String urlw = url.substring(4, url.length());
		String strs = url.substring(0, 2) + url.substring(4, url.length());
		System.out.println(strs);
//		for(int i = 0;i < strs.length;i++){
//			System.out.println(strs[i]);
//		}
//		
//		String sourceStr = "1,2,3,4,5";
//		String[] sourceStrArray = sourceStr.split(",");
//		for (int i = 0; i < sourceStrArray.length; i++) {
//		    System.out.println(sourceStrArray[i]);
//		}
	}

}
