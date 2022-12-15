package com.simonsays.service;

import com.simonsays.model.Command;
import com.simonsays.repository.CommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CommandService {

	@Autowired
	CommandRepository commandRepository;

	public List<Command> getAllCommands() {
		List<Command> commands = new ArrayList<>();
		commandRepository.findAll().forEach(commands::add);
		return commands;
	}

	public Command getCommandById(int id) {
		return commandRepository.findById(id).get();
	}

	public Command getRandomCommand() {
		List<Command> commands = new ArrayList<>();
		commandRepository.findAll().forEach(commands::add);
		return this.getRandomCommand(commands);
	}

	public void saveOrUpdate(Command command) {
		commandRepository.save(command);
	}

	public void deleteCommandById(int id) {
		commandRepository.deleteById(id);
	}

	private Command getRandomCommand(List<Command> commands) {
		Random rand = new Random();
		return commands.get(rand.nextInt(commands.size()));
	}
}
