package com.oesia.formacion.practica.architecture.persistence.entities;

import java.util.List;

public interface Entity<E> {

	E findById(Integer id);

	List<E> findAll();
}
