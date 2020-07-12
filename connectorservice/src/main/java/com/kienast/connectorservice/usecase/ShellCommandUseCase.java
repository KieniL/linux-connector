package com.kienast.connectorservice.usecase;

import com.kienast.connectorservice.command.ShellCommand;
import com.kienast.connectorservice.model.Connection;
import com.kienast.connectorservice.model.ConnectionStatus;
import com.kienast.connectorservice.repository.ConnectionRepository;

public class ShellCommandUseCase {

	private ConnectionRepository connectionRepository;
	private ShellCommand command;

	public ShellCommandUseCase(ConnectionRepository connectionRepository, ShellCommand command) {
		this.connectionRepository = connectionRepository;
		this.command = command;
	}

	public String addCommand() {
		return connectionRepository.addCommand(command);
	}
}
