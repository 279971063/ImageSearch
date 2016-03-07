package csust.imageSearch.orm.dao;

import csust.imageSearch.orm.IndexLocation;



public interface IndexLocationDao {
	/**
	 * 用于跟新地址
	 * @return
	 */
	public int updateLocation(String newurl);
	/**
	 * 通过序号来的到id地址
	 * @return
	 */
	public IndexLocation getRootLocation(int id);
}
