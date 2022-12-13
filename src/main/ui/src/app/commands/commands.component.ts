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

  constructor(private commandService: CommandService) {}

  ngOnInit(): void {
    this.getCommands();
  }
  getCommands() {
    this.commandService
      .getCommands()
      .subscribe((command) => (this.commands = command));
  }
}
