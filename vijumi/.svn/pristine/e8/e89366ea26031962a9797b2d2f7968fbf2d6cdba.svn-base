package com.oesia.formacion.practica.architecture.persistence.entities;

import java.util.List;

import com.oesia.formacion.practica.architecture.persistence.daos.Dao;

public abstract class AbstractEntity<E> implements Entity<E> {

	private final Dao<E> dao;

	protected AbstractEntity(Dao<E> dao) {
		this.dao = dao;
	}

	@Override
	public E findById(Integer id) {
		return (E) dao.findById(id);
	}

	@Override
	public List<E> findAll() {
		return dao.findAll();
	}
}
