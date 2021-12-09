package me.nickm980.argsparse.example;

import java.util.ArrayList;

import me.nickm980.argsparse.Command;
import me.nickm980.argsparse.CommandExecutor;

@Command(name="command2", description = "This is a short description")
public class ExampleCommandWithAnnotations extends CommandExecutor {

    @Override
    public boolean onCommand(String command, ArrayList<String> args) {
	System.out.println("Command 2 executed (annotations)");
	return false;
    }

}
