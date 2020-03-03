package com.oesia.formacion.practica.architecture.communications;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.oesia.formacion.practica.architecture.communications.processors.InfoMessageInformationProcessor;
import com.oesia.formacion.practica.architecture.communications.processors.PutInformationProcessor;
import com.oesia.formacion.practica.architecture.domain.model.Message;
import com.oesia.formacion.practica.context.ContextFactory;

public class MessageManagerImpl implements MessageManager {

	@Override
	public void recive(String message) {

		Message information = getMessageInformation(message);
		switch (information.getOperation()) {
		case "PUT":
			PutInformationProcessor putInformationProcessor = ContextFactory.getContext()
					.get(PutInformationProcessor.class);
			putInformationProcessor.process(information);
			break;

		case "INFO":
			InfoMessageInformationProcessor infoInformationProcessor = ContextFactory.getContext()
					.get(InfoMessageInformationProcessor.class);
			infoInformationProcessor.process(information);
			break;

		default:
			send(" ---- KO ----   No valid operation.\n");
			break;
		}
	}

	@Override
	public void send(String message) {
		System.out.print(message);
	}

	private List<String> getListaMessages(String message) {
		List<String> listaMessages = new ArrayList<String>();
		String[] divMessage = message.split("\\*");
		for (int i = 0; i < divMessage.length; i++) {
			listaMessages.add(divMessage[i]);
		}
		return listaMessages;
	}

	private Message getMessageInformation(String messageOriginal) {
		List<String> listaMensajes = getListaMessages(messageOriginal);
		Message messageWrapper = setMessageInformation(listaMensajes);
		return messageWrapper;
	}

	private Message setMessageInformation(List<String> mensajesSinSplitear) {
		Message message = new Message();
		List<List<String>> messageList = new ArrayList<List<String>>();
		for (int i = 0; i < mensajesSinSplitear.size(); i++) {
			List<String> atributeList = Arrays.asList(mensajesSinSplitear.get(i).split("\\|"));
			if (i == 0) {
				List<String> modifiedAtributeList = setAtributeList(message, atributeList);
				messageList.add(modifiedAtributeList);
			} else {
				messageList.add(atributeList);
			}
		}
		message.setRecords(messageList);
		return message;
	}

	private List<String> setAtributeList(Message message, List<String> atributeList) {
		message.setOperation(atributeList.get(0));
		List<String> modifiedAtributeList = new ArrayList<String>();
		for (int iterator = 1; iterator < atributeList.size(); iterator++) {
			modifiedAtributeList.add(atributeList.get(iterator));
		}
		return modifiedAtributeList;
	}

}
