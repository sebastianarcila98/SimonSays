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

import java.util.ArrayList;
import java.util.List;

@RestController
public class CommandController {

	@Autowired
	CommandService commandService;


	@GetMapping("/commands")
	private List<Command> getAllCommands() {
		List<Command> commands = commandService.getAllCommands();
		commands.forEach(command -> System.out.println("List of all commands >>> " + command.getName()));
		return commands;
	}

	@GetMapping("/commands/{id}")
	private Command getCommand(@PathVariable("id") int id) {
		Command command = commandService.getCommandById(id);
		System.out.println("Command that was requested >>> " + command.getName());
		return command;
	}

	@GetMapping("/commands/random")
	private Command getRandomCommand() {
		Command command = commandService.getRandomCommand();
		System.out.println("Random command >>> " + command.getName());
		return command;
	}

	@PostMapping("/commands")
	private int saveCommand(@RequestBody Command command) {
		commandService.saveOrUpdate(command);
		return command.getId();
	}

	@DeleteMapping("commands/{id}")
	private void deleteCommand(@PathVariable("id") int id) {
		commandService.deleteCommandById(id);
	}

}
