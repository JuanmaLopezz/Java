package com.oesia.formacion.practica.remote;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.oesia.formacion.practica.architecture.communications.MessageManager;
import com.oesia.formacion.practica.context.ContextFactory;

public class RemoteSender {

	private static final Logger LOGGER = Logger.getLogger(RemoteSender.class);

	private static final String COMMAND_FILE_NAME = "comandos";

	private final MessageManager messageManager;

	public RemoteSender() {
		messageManager = ContextFactory.getContext().get(MessageManager.class);
	}

	public void sendCommands() {
		final List<String> commands = readCommands();

		if (commands != null) {
			for (String command : commands) {
				LOGGER.info(String.format("Se envía comando [%s]", command));
				messageManager.recive(command);
			}
		}
	}

	private List<String> readCommands() {
		final List<String> commands = new ArrayList<String>();

		final File file = getCommandsFile();

		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		String line = null;

		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				if (!line.trim().isEmpty() && !line.startsWith("#")) {
					commands.add(line);
				}
			}
		} catch (FileNotFoundException exception) {
			fileNotExits();
		} catch (IOException exception) {
			LOGGER.error(String.format("Se ha producido un error al procesar la línea de comando [%s]. Error =>\n%s", line, exception.getMessage()));
			System.exit(0);
		} finally {
			if (null != bufferedReader) {
				try {
					bufferedReader.close();
					fileReader.close();
				} catch (IOException exception) {
					LOGGER.error(String.format("Se ha producido un error al cerrar el fichero de comandos [%s]. Error =>\n%s", COMMAND_FILE_NAME,
							exception.getMessage()));
					System.exit(0);
				}
			}
		}

		LOGGER.debug(String.format("Lista de commandos %s", Arrays.toString(commands.toArray())));
		return commands;
	}

	private File getCommandsFile() {
		final URL commandsFilePath = this.getClass().getClassLoader().getResource(COMMAND_FILE_NAME);
		if (commandsFilePath == null) {
			fileNotExits();
		}
		return new File(commandsFilePath.getFile());
	}

	private void fileNotExits() {
		LOGGER.error(String.format("No se encuentra el fichero de comandos [%s]", COMMAND_FILE_NAME));
		System.exit(0);
	}
}