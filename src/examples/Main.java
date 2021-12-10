package examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import me.nickm980.argsparse.CommandRegistry;
import me.nickm980.argsparse.ICommand;

public class Main {

    public static void main(String args[]) throws IOException {
	registerCommands();
	commandLoop();
    }
    
    private static void registerCommands() {
	ICommand cmd = new ExampleCommand();
	ICommand annotationsCmd = new ExampleCommandWithAnnotations();
	
	CommandRegistry.registerCommands(cmd, annotationsCmd);
    }
    
    private static void commandLoop() throws IOException {
	while (true) {
	    System.out.print(">> ");
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    String command = reader.readLine();
	    
	    //Must execute the command based on the name of the argument.
	    CommandRegistry.executeCommand(command, null);
	}
    }
}
