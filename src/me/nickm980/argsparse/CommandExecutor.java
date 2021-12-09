package me.nickm980.argsparse;

import java.util.ArrayList;

public abstract class CommandExecutor implements ICommand {

    private Command info = getClass().getAnnotation(Command.class);

    public String getName() {
	return info.name();
    }
    
    public String getDescription() {
	return info.description();
    }
    
    public abstract boolean onCommand(String command, ArrayList<String> args);

}
