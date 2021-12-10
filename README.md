# args-parse
Java command line argument parser. Parse arguments and execute commands with ease, in a modular and simple way

## How To Use
Create a subclass of [ICommand](https://github.com/nickm980/argsparse/blob/7455cd396f53061f9b437416f82cf20b0c49d459/src/me/nickm980/argsparse/ICommand.java) and add code to execute under the onCommand method, or extend [CommandExecutor](https://github.com/nickm980/argsparse/blob/7455cd396f53061f9b437416f82cf20b0c49d459/src/me/nickm980/argsparse/CommandExecutor.java).

### Creating a new command
An example of a command with annotations.
```java
@Command(name="command2", description = "This is a short description")
public class ExampleCommandWithAnnotations extends CommandExecutor {

    @Override
    public boolean onCommand(String command, ArrayList<String> args) {
	System.out.println("Command 2 executed (annotations)");
	return false;
    }

}
```
*You can also view an example without annotations in the [examples directory](https://github.com/nickm980/argsparse/blob/main/src/examples/).*

### Registering commands
To register commands, use either method (registerCommand for singular commands, or registerCommands for multiple commands) of the CommandRegistry class.

```java
CommandRegistry.registerCommand(new ExampleCommand());
```

Or to register multiple commands at once
```java
CommandRegistry.registerCommands(new ExampleCommand(), new ExampleCommand1());
```
*Note:* You must also create a method for executing commands in the command registry for the commands to work.

### Executing commands
To execute commands, call the CommandRegistry.executeCommand(commandName, argumentList) method
```java
CommandRegistry.executeCommand(commandName, argumentList);
```

A full example of Main.java, where the application waits for a command and then executes it based on the name.
```java
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
      //Note: No arguments were passed into this example, but you can add that functionality if you wish
	    CommandRegistry.executeCommand(command, null);
	}
    }
}
```
## Contributing
Feel free to submit issues, requests, and contribute to the project. In general, we follow the "fork-and-pull" Git workflow.

1. Fork the repo on GitHub
2. Clone the project to your own machine
3. Commit changes to your own branch
4. Push your work back up to your fork
5. Submit a Pull request so that we can review your changes

*NOTE: Be sure to merge the latest from "upstream" before making a pull request!*
