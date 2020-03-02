package com.oesia.formacion.practica.architecture.communications.processors;

import java.util.List;

import com.oesia.formacion.practica.architecture.communications.MessageManager;
import com.oesia.formacion.practica.architecture.communications.messages.stock.StockMessageInformation;
import com.oesia.formacion.practica.architecture.communications.messages.stock.StockMessageInformation.Builder;
import com.oesia.formacion.practica.architecture.domain.managers.article.ArticleManager;
import com.oesia.formacion.practica.architecture.domain.model.Article;
import com.oesia.formacion.practica.architecture.domain.model.Message;
import com.oesia.formacion.practica.context.ContextFactory;

public class StockInformationProcessor implements Processor {

	private static final int STOCK_ARTICLE_ID_POSITION = 0;

	@Override

	public void process(Message message) {

		for (List<String> row : message.getRecords()) {

			int idArticle = Integer.parseInt(row.get(STOCK_ARTICLE_ID_POSITION));

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
				
				messageManager.send(String.format("STOCK|%s|%s|%s|%s|%s", idArticle, articleDataBase.getDescription(), articleDataBase.getColour(), articleDataBase.getSize(), articleDataBase.getNumUnit()));

				StockMessageInformation stockMessageInformation = stockBuilder.build();
			} else {
				messageManager.send("KO");
			}
		}
	}
}