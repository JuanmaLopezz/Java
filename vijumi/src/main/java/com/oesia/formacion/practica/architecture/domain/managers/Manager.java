package com.oesia.formacion.practica.architecture.domain.managers;

import java.util.List;

public interface Manager<E> {

	E findById(Integer id);

	List<E> findAll();
}
