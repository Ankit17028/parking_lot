package com.parking.mode;

import com.parking.OutputPrinter;
import com.parking.commands.CommandExecutor;
import com.parking.commands.CommandExecutorFactory;
import com.parking.exception.InvalidCommandException;
import com.parking.model.Command;
import java.io.IOException;

/**
 * Interface for mode of the program in which it can be run.
 */
public abstract class Mode {

  private CommandExecutorFactory commandExecutorFactory;
  protected OutputPrinter outputPrinter;

  public Mode(
      final CommandExecutorFactory commandExecutorFactory, final OutputPrinter outputPrinter) {
    this.commandExecutorFactory = commandExecutorFactory;
    this.outputPrinter = outputPrinter;
  }

  /**
   * Helper method to process a command. It basically uses {@link CommandExecutor} to run the given
   * command.
   *
   * @param command Command to be processed.
   */
  protected void processCommand(final Command command) {
    final CommandExecutor commandExecutor = commandExecutorFactory.getCommandExecutor(command);
    if (commandExecutor.validate(command)) {
      commandExecutor.execute(command);
    } else {
      throw new InvalidCommandException();
    }
  }

  /**
   * Abstract method to process the mode. Each mode will process in its own way.
   *
   * @throws IOException
   */
  public abstract void process() throws IOException;
}
