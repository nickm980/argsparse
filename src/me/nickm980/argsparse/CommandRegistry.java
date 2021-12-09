package me.nickm980.argsparse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CommandRegistry {

    private CommandRegistry() {
    }

    private static Map<String, ICommand> commands = new HashMap<String, ICommand>();

    public static void registerCommand(ICommand command) {
	commands.put(command.getName(), command);
    }
    
    public static void registerCommands(ICommand... commands) {
	for (ICommand cmd : commands) {
	    registerCommand(cmd);
	}
    }

    public static boolean executeCommand(String name, ArrayList<String> args) {
	ICommand command = commands.get(name);

	if (command == null) {
	    System.out.println("Command not found.");
	    return false;
	}

	return command.onCommand(name, args);
    }

    public static Collection<ICommand> getCommands() {
	return Collections.unmodifiableCollection(commands.values());
    }
}
