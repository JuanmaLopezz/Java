package com.oesia.formacion.practica.architecture.persistence.daos.article;

import com.oesia.formacion.practica.architecture.domain.model.Article;
import com.oesia.formacion.practica.architecture.domain.model.Size;
import com.oesia.formacion.practica.architecture.persistence.daos.Dao;

public interface ArticleDao extends Dao<Article> {

	Size findSizeById(Integer sizeId);

	void update(Article article);
	
	void create(Article article);
}
