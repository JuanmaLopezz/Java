package com.oesia.formacion.practica.architecture.communications.processors;

import java.util.List;

import com.oesia.formacion.practica.architecture.communications.MessageManager;
import com.oesia.formacion.practica.architecture.communications.messages.info.InfoMessageInformation;
import com.oesia.formacion.practica.architecture.communications.messages.info.InfoMessageInformation.Builder;
import com.oesia.formacion.practica.architecture.domain.model.Message;
import com.oesia.formacion.practica.context.ContextFactory;

public class InfoMessageInformationProcessor implements Processor{
	
	private static final int COD_ARTICLE_POSITION = 2;

	@Override
	public void process(Message message) {
		for (List<String> row : message.getRecords()) {
			int idArticle = Integer.parseInt(row.get(COD_ARTICLE_POSITION));
			
			InfoMessageInformation.Builder infoMessageBuilder = new Builder();
			infoMessageBuilder.idArticle(idArticle);
			infoMessageBuilder.build();
			
			MessageManager messageManager = ContextFactory.getContext().get(MessageManager.class);
			
		}
		
		
	}

}
