import { Component, OnInit } from '@angular/core';

import { Command } from '../command';
import { CommandService } from '../command.service';

@Component({
  selector: 'app-commands',
  templateUrl: './commands.component.html',
  styleUrls: ['./commands.component.scss'],
})
export class CommandsComponent implements OnInit {
  commands: Command[] = [];
  randomCommand: Command | undefined;

  constructor(private commandService: CommandService) {}

  ngOnInit(): void {
    this.getAllCommands();
  }

  getAllCommands() {
    this.commandService
      .getCommands()
      .subscribe((command) => (this.commands = command));
  }

  getRandom() {
    this.commandService
      .getRandomCommand()
      .subscribe((command) => (this.randomCommand = command));
  }
}
