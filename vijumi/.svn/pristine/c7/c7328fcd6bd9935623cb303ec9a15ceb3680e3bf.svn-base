package com.oesia.formacion.practica.architecture.domain.managers.article;

import com.oesia.formacion.practica.architecture.communications.messages.put.PutMessageInformation;
import com.oesia.formacion.practica.architecture.domain.managers.Manager;
import com.oesia.formacion.practica.architecture.domain.model.Article;
import com.oesia.formacion.practica.architecture.domain.model.Size;

public interface ArticleManager extends Manager<Article> {

	Size findSizeById(Integer sizeId);

	void update(Article article);

	void createArticleOrUpdateStock(PutMessageInformation putMessageInformation) throws Exception;
	
	//TODO: Añadir resto de métodos
}
