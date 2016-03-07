package csust.imageSearch.orm.dao;

import csust.imageSearch.orm.Picture;

public interface PictureDao {
	/**
	 * 通过图片的名字得到图片的完整信息
	 * @param name
	 * @return
	 */
	public Picture getPictueByName(String name);
}
