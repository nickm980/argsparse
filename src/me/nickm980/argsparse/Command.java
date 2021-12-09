package me.nickm980.argsparse;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Command {
    
    /**
     * Name of the command
     */
    String name();

    /**
     * Full description of the command
     */
    String description();
}
