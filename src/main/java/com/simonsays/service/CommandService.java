package com.simonsays.service;

import com.simonsays.model.Command;
import com.simonsays.repository.CommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

	public void saveOrUpdate(Command command) {
		commandRepository.save(command);
	}

	public void deleteCommandById(int id) {
		commandRepository.deleteById(id);
	}
}
