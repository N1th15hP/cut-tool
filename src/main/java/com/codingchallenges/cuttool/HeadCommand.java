package com.codingchallenges.cuttool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Component;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Component
@Command(name="head", description = "returns the specific number of lines from the stream")
public class HeadCommand implements Runnable {

    @Option(names = {"-n", "--number of lines"}, description = "The number of lines to return", defaultValue = "1", required = true)
    private int numberOfLines;

	@Override
	public void run() {
		System.out.println(numberOfLines);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null && count < numberOfLines) {
                System.out.println(line);
                count++;
            }
        } catch (IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
        }
    
	}
}
