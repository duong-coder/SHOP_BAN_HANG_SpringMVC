package com.duong.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.duong.dao.ProductDAO;
import com.duong.entity.ChiTietSanPham;
import com.duong.entity.SanPham;

@Repository
public class ProductDAOImpl implements ProductDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void insertProduct(SanPham sp) throws Exception {
		Session session = sessionFactory.openSession();
		session.save(sp);
		session.flush();
		session.close();
	}

	@Override
	public void updateProduct(SanPham sp) throws Exception {
		Session session = sessionFactory.openSession();
		session.update(sp);
		session.flush();
		session.close();
	}

	@Override
	public void deleteProductByMaSp(String maSp) throws Exception {
		Session session = sessionFactory.openSession();
		SanPham sp = getProuctByMaSp(maSp);
		session.delete(sp);
		session.flush();
		session.close();
	}

	@Override
	public SanPham getProuctByMaSp(String maSp) throws Exception {
		Session session = sessionFactory.openSession();
		SanPham sp = (SanPham) session.get(SanPham.class, maSp);
		session.close();
		return sp;
	}

	@Override
	public List<SanPham> getAllProduct() throws Exception {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(SanPham.class);
		return criteria.list();
	}
	
	@Override
	public List<SanPham> getTopProduct(int soLuong) throws Exception {
		Session session = sessionFactory.openSession();
		String hql = "from SanPham";
		Query query = session.createQuery(hql);
		query.setMaxResults(soLuong);
//		Criteria criteria = session.createCriteria("FROM Sanpham LIMIT " + soLuong);
		List<SanPham> sanphams = query.list();
		session.close();
		return sanphams;
	}
	
	@Override
	public List<ChiTietSanPham> getAllProductDetailByMaSP(String maSP) throws Exception {
		Session session = sessionFactory.openSession();
		SanPham sanPham = (SanPham) session.get(SanPham.class, maSP);
		if(sanPham != null) {
			List<ChiTietSanPham> ctsps = sanPham.getChiTietSanPhams();
			for(ChiTietSanPham ctsp:ctsps) {
				System.out.println(ctsp.getIdChiTiet() + "///" + ctsp.getMauSac().getTenMau()
						+  "///" + ctsp.getSanPham().getTenSP() + "///" + + ctsp.getSoLuong());
			}
			session.close();
			return ctsps;
		}
		
		return null;
	}
}
