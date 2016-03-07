package csust.imageSearch.orm.dao.impl;

import csust.imageSearch.orm.Picture;
import csust.imageSearch.orm.dao.PictureDao;

public class PictureDaoImpl extends Base implements PictureDao{

	@Override
	public Picture getPictueByName(String name) {
		String hql = "from Picture picture where picture.name = ?";
		return (Picture) this.getSession().createQuery(hql).setString(0, name).uniqueResult();
	}

}
