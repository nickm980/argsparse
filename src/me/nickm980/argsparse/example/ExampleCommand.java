package me.nickm980.argsparse.example;

import java.util.ArrayList;

import me.nickm980.argsparse.ICommand;

public class ExampleCommand implements ICommand {

    @Override
    public String getName() {
	return "command1";
    }

    @Override
    public String getDescription() {
	return "This is Example command1";
    }

    @Override
    public boolean onCommand(String command, ArrayList<String> args) {
	System.out.println("Command 1 executed. (No annotations)");
	return false;
    }

}
