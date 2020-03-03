package com.oesia.formacion.practica.architecture.communications.processors;

import com.oesia.formacion.practica.architecture.communications.MessageManager;
import com.oesia.formacion.practica.architecture.communications.messages.info.InfoMessageInformation;
import com.oesia.formacion.practica.architecture.communications.messages.stock.StockMessageInformation;
import com.oesia.formacion.practica.architecture.communications.messages.stock.StockMessageInformation.Builder;
import com.oesia.formacion.practica.architecture.domain.managers.article.ArticleManager;
import com.oesia.formacion.practica.architecture.domain.model.Article;
import com.oesia.formacion.practica.context.ContextFactory;

public class StockInformationProcessor {

	public void process(InfoMessageInformation infoMessageInformation) {

		for (String idArticleString : infoMessageInformation.getArticleIdsList()) {
			Integer idArticle = Integer.parseInt(idArticleString);

			ArticleManager articleManager = ContextFactory.getContext().get(ArticleManager.class);
			MessageManager messageManager = ContextFactory.getContext().get(MessageManager.class);

			Article articleDataBase = articleManager.findById(idArticle);

			if (articleDataBase != null) {
				StockMessageInformation.Builder stockBuilder = new Builder();
				stockBuilder.idArticle(idArticle);
				stockBuilder.descriptionArticle(articleDataBase.getDescription());
				stockBuilder.idColor(articleDataBase.getColour().getId());
				stockBuilder.idTalla(articleDataBase.getSize().getId());
				stockBuilder.numUds(articleDataBase.getNumUnit());

				StockMessageInformation stockInformation = stockBuilder.build();

				messageManager.send(String.format("STOCK|%s|%s|%s|%s|%s\n", stockInformation.getIdArticle(),
						stockInformation.getDescriptionArticle(), stockInformation.getIdColor(),
						stockInformation.getIdTalla(), stockInformation.getNumUds()));

			} else {

				messageManager.send(String.format("---- KO ---- El articulo con id[%s] no se encuentra en los datos", idArticle));
			}
		}
	}
}