package com.codingchallenges.cuttool;


import org.springframework.stereotype.Component;
import picocli.CommandLine.Command;

@Component
@Command(name = "", subcommands = {CutCommand.class, HeadCommand.class}, mixinStandardHelpOptions = true, description = "")
public class RootCommand implements Runnable {

    @Override
    public void run() {

    }
}

