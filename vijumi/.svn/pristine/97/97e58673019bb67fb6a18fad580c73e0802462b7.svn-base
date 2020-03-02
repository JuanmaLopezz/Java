package com.oesia.formacion.practica;

import org.apache.log4j.Logger;

import com.oesia.formacion.practica.context.Context;
import com.oesia.formacion.practica.context.ContextFactory;
import com.oesia.formacion.practica.remote.RemoteManager;
import com.oesia.formacion.practica.remote.RemoteManagerImpl;
import com.oesia.formacion.practica.remote.RemoteSender;

public class App {

	private static final String NOMBRE_APP = "Aplicación de Formación";

	private static final Logger LOGGER = Logger.getLogger(App.class);

	private final RemoteSender sender;

	public static void main(String[] args) {
		new App().start();
	}

	public App() {
		final Context context = ContextFactory.getContext();
		context.set(RemoteManager.class, new RemoteManagerImpl());
		context.start();

		sender = new RemoteSender();
	}

	private void start() {
		LOGGER.info(String.format("Arrancando [%s]", NOMBRE_APP));

		sender.sendCommands();
	}
}
