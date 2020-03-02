package com.oesia.formacion.practica.architecture.persistence.daos.article;

import java.util.ArrayList;
import java.util.List;

import com.oesia.formacion.practica.architecture.domain.model.Article;
import com.oesia.formacion.practica.architecture.domain.model.Size;

public class ArticleDaoImpl implements ArticleDao {

//	private static final Logger LOGGER = Logger.getLogger(ArticleDaoImpl.class);

	private final List<Article> data;

	public ArticleDaoImpl() {
		data = new ArrayList<Article>();
	}

	@Override
	public List<Article> findAll() {
		return data;
	}

	@Override
	public Size findSizeById(Integer sizeId) {
		return Size.findById(sizeId);
	}

	@SuppressWarnings("unused")
	@Override
	public void update(Article article) {
		Article found = findById(article.getArticleId());
		found = article;
	}

	@Override
	public void create(Article article) {
		data.add(article);
	}

	@Override
	public Article findById(Integer id) {
		
		Article res = null;
		
		for (int i=0; i < data.size(); i++) {
			if (data.get(i).getArticleId() == id) {
				return data.get(i);
			}
		}
		
		return res;
	}
}
