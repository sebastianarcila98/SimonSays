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
      .getAllCommands()
      .subscribe((command) => (this.commands = command));
  }

  deleteCommand(id: number) {
    this.commandService.deleteCommand(id).subscribe();
    this.commands = this.commands.filter((command) => command.id != id);
  }

  getRandom() {
    this.commandService
      .getRandomCommand()
      .subscribe((command) => (this.randomCommand = command));
  }
}
