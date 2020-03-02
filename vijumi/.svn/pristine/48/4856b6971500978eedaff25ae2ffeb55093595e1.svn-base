package com.oesia.formacion.practica.architecture.domain.managers;

import java.util.List;

import com.oesia.formacion.practica.architecture.persistence.entities.Entity;

public abstract class AbstractManager<E> {

	private final Entity<E> entity;

	protected AbstractManager(Entity<E> entity) {
		this.entity = entity;
	}

	public E findById(Integer id) {
		return entity.findById(id);
	}

	public List<E> findAll() {
		return entity.findAll();
	}
}
