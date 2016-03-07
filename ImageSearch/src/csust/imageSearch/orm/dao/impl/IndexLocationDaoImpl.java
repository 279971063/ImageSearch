package csust.imageSearch.orm.dao.impl;

import csust.imageSearch.orm.IndexLocation;
import csust.imageSearch.orm.dao.IndexLocationDao;


public class IndexLocationDaoImpl extends Base implements IndexLocationDao{

	@Override
	public int updateLocation(String newurl) {
		String hql = "update IndexLocation indexLocation set indexLocation.value = ? where indexLocation.id = 2";

		return this.getSession().createQuery(hql).setString(0, newurl).executeUpdate();
	}

	@Override
	public IndexLocation getRootLocation(int id) {
		String hql = "from IndexLocation indexLocation where indexLocation.id = ?";
		return (IndexLocation)this.getSession().createQuery(hql).setInteger(0, id).uniqueResult();
	}

}
