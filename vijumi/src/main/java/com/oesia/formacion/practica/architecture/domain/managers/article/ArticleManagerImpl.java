package com.oesia.formacion.practica.architecture.domain.managers.article;

import org.apache.log4j.Logger;

import com.oesia.formacion.practica.architecture.communications.messages.put.PutMessageInformation;
import com.oesia.formacion.practica.architecture.domain.managers.AbstractManager;
import com.oesia.formacion.practica.architecture.domain.model.Article;
import com.oesia.formacion.practica.architecture.domain.model.Article.Builder;
import com.oesia.formacion.practica.architecture.domain.model.Size;
import com.oesia.formacion.practica.architecture.persistence.entities.article.ArticleEntity;
import com.oesia.formacion.practica.remote.RemoteSender;

public class ArticleManagerImpl extends AbstractManager<Article> implements ArticleManager {

	private final ArticleEntity articleEntity;

	private static final Logger LOGGER = Logger.getLogger(RemoteSender.class);

	public ArticleManagerImpl(ArticleEntity articleEntity) {
		super(articleEntity);
		this.articleEntity = articleEntity;
	}

	@Override
	public Size findSizeById(Integer sizeId) {
		return articleEntity.findSizeById(sizeId);
	}

	@Override
	public void update(Article article) {
		articleEntity.update(article);
	}

	@Override
	public void createArticleOrUpdateStock(PutMessageInformation put) throws Exception {
		checkSize(put);
		checkColour(put);
		checkVendor(put);
		Article article = buildArticleByPutInformation(put);
//		if (Size.findById(put.getIdTalla()) == null || Colour.findById(put.getIdColor()) == null
//				|| VendorData.findById(put.getIdVendor()) == null) {
//			Exception e = new Exception();
//			LOGGER.error(String.format("Se ha producido un error al procesar la operacion PUT de articulo con id: [%s]. Error => %s", put.getIdArticle(), e.getMessage()));
//			throw e;
//		}
		Article articleDataBase = articleEntity.findById(put.getIdArticle());
		if (articleDataBase != null) {
			actualizaArticuloDataBase(articleDataBase, article);
			articleEntity.update(articleDataBase);
			LOGGER.debug(String.format("Articulo con id: %s, actualizado correctamente", article.getArticleId()));
		} else {
			articleEntity.create(article);
			LOGGER.debug(String.format("Articulo con id: %s, creado correctamente", put.getIdArticle()));
		}
	}

	private Article buildArticleByPutInformation(PutMessageInformation put) {
		Article.Builder articleBuilder = new Builder();
		articleBuilder.articleId(put.getIdArticle());
		articleBuilder.vendordata(put.getVendor());
		articleBuilder.colour(put.getColor());
		articleBuilder.description(put.getDescriptionArticle());
		articleBuilder.size(put.getTalla());
		articleBuilder.numUnit(put.getNumUds());

		Article res = articleBuilder.build();
		return res;

	}

	private void checkSize(PutMessageInformation put) throws Exception {
		if (put.getTalla() == null) {
			Exception e = new Exception();
			LOGGER.error(String.format("Se ha producido un error al insertar la TALLA: [%s]. Error => %s",
					put.getIdTalla(), e.getMessage()));
			throw e;
		}
	}

	private void checkVendor(PutMessageInformation put) throws Exception {
		if (put.getVendor() == null) {
			Exception e = new Exception();
			LOGGER.error(String.format("Se ha producido un error al insertar el VENDEDOR: [%s]. Error => %s",
					put.getIdVendor(), e.getMessage()));
			throw e;
		}
	}

	private void checkColour(PutMessageInformation put) throws Exception {
		if (put.getColor() == null) {
			Exception e = new Exception();
			LOGGER.error(String.format("Se ha producido un error al insertar el COLOR: [%s]. Error => %s",
					put.getIdColor(), e.getMessage()));
			throw e;
		}
	}
	
	private void actualizaArticuloDataBase(Article articleDataBase, Article article) {
		
		int stockUpdate = articleDataBase.getNumUnit() + article.getNumUnit();
		articleDataBase.setColour(article.getColour());
		articleDataBase.setDescription(article.getDescription());
		articleDataBase.setVendordata(article.getVendordata());
		articleDataBase.setNumUnit(stockUpdate);
		articleDataBase.setSize(article.getSize());
	}

}