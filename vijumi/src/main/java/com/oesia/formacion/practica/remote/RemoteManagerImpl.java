package com.oesia.formacion.practica.remote;

import org.apache.log4j.Logger;

public class RemoteManagerImpl implements RemoteManager {

	private static final Logger LOGGER = Logger.getLogger(RemoteManagerImpl.class);

	public void recive(String message) {
		LOGGER.debug(String.format("Se recive el mensaje [%s]", message));
	}
}
