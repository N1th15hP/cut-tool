package com.codingchallenges.cuttool;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

import java.util.Scanner;

@Component
public class InteractiveCliRunner implements CommandLineRunner {

    private final CommandLine.IFactory factory; // Picocli factory
    private final ApplicationContext context;

    public InteractiveCliRunner(CommandLine.IFactory factory, ApplicationContext context) {
        this.factory = factory;
        this.context = context;
    }

    @Override
    public void run(String... args) {
        CommandLine commandLine = new CommandLine(context.getBean(RootCommand.class), factory);
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if ("exit".equalsIgnoreCase(input)) {
                System.out.println("Exiting CLI. Goodbye!");
                break;
            }

            // Split input into arguments and execute command
            String[] parsedInput = input.split("\\s+");
            commandLine.execute(parsedInput);
        }

        scanner.close();
    }
}
