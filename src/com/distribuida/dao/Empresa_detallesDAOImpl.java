package com.distribuida.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.distribuida.entities.Empresa_detalles;

@Repository
public class Empresa_detallesDAOImpl implements Empresa_detallesDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Empresa_detalles> findAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Empresa_detalles", Empresa_detalles.class).getResultList();
		
	}

	@Override
	@Transactional
	public Empresa_detalles findOne(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(Empresa_detalles.class, id);
	}

	@Override
	@Transactional
	public void add(Empresa_detalles empresa_detalles) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(empresa_detalles);

	}

	@Override
	@Transactional
	public void up(Empresa_detalles empresa_detalles) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(empresa_detalles);
	}

	@Override
	@Transactional
	public void del(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(findOne(id));
	}
	
	@Override
	@Transactional
	public List<Empresa_detalles> findCustom(String busqueda) {
	    Session session = sessionFactory.getCurrentSession();
	    Query<Empresa_detalles> query = session.createQuery("FROM Empresa_detalles au WHERE "
	            + "au.tipoEmpresa LIKE :busqueda OR "
	            + "au.encuestapopularidad LIKE :busqueda OR "
	            + "au.Comentarios LIKE :busqueda OR "
	            + "au.ChatUsuario LIKE :busqueda OR "
	            + "au.ChatCliente LIKE :busqueda OR "
	            + "au.HorariosAtencion LIKE :busqueda OR "
	            + "au.empresa LIKE :busqueda OR "
	            + "au.sucursales LIKE :busqueda", Empresa_detalles.class);

	    query.setParameter("busqueda", "%" + busqueda + "%");
	    return query.getResultList();
	}
	
}
