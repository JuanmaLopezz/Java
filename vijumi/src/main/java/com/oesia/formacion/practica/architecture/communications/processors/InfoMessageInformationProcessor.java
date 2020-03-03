package com.oesia.formacion.practica.architecture.communications.processors;

import java.util.List;

import com.oesia.formacion.practica.architecture.communications.MessageManager;
import com.oesia.formacion.practica.architecture.communications.messages.info.InfoMessageInformation;
import com.oesia.formacion.practica.architecture.communications.messages.info.InfoMessageInformation.Builder;
import com.oesia.formacion.practica.architecture.domain.model.Message;
import com.oesia.formacion.practica.context.ContextFactory;

public class InfoMessageInformationProcessor implements Processor {

	@Override
	public void process(Message message) {
		for (List<String> row : message.getRecords()) {

			InfoMessageInformation.Builder infoMessageBuilder = new Builder();
			infoMessageBuilder.articleIdsList(row);
			InfoMessageInformation infoMessage = infoMessageBuilder.build();
			
			StockInformationProcessor stockProcessor = ContextFactory.getContext().get(StockInformationProcessor.class);
			MessageManager messageManager = ContextFactory.getContext().get(MessageManager.class);
			try {
				stockProcessor.process(infoMessage);
			} catch (Exception e) {
				messageManager.send(String.format("---- KO ---- [%s]", e.getMessage()));
			}
		}

	}

}
