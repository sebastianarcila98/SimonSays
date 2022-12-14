package com.simonsays.controller;

import com.simonsays.model.Command;
import com.simonsays.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommandController {

	@Autowired
	CommandService commandService;


	@GetMapping("/commands")
	private List<Command> getAllCommands() {
		List<Command> commands = commandService.getAllCommands();
		return commands;
	}

	@GetMapping("/commands/{id}")
	private Command getCommand(@PathVariable("id") int id) {
		Command command = commandService.getCommandById(id);
		return command;
	}

	@GetMapping("/commands/random")
	private Command getRandomCommand() {
		Command command = commandService.getRandomCommand();
		return command;
	}

	@PostMapping("/commands")
	private Command saveCommand(@RequestBody String command) {
		return commandService.saveOrUpdate(command);
	}

	@DeleteMapping("commands/{id}")
	private void deleteCommand(@PathVariable("id") int id) {
		commandService.deleteCommandById(id);
	}

}
