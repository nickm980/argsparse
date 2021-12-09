package me.nickm980.argsparse;

import java.util.ArrayList;

public interface ICommand {

    /**
     * Get the name of the argument
     * 
     * @return Name
     */
    String getName();

    /**
     * Get the full description of the command
     * 
     * @return Description
     */
    String getDescription();

    /**
     * Add actions to a command
     * 
     * @param command Name of the command
     * @param args    Arguments passed to the command.
     * @return True if command succeeded, false if something failed
     */
    boolean onCommand(String command, ArrayList<String> args);
}
