package com.codingchallenges.cuttool;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Component
@Command(name = "cut", description = "cuts out selected portions from a file")
public class CutCommand implements Runnable {

    @Parameters(index = "0", description = "The path to the tab-separated file.", arity = "1")
    private String filePath;
    
    @Option(names = {"-f", "--field"}, description = "The field to extract (default is 1).", defaultValue = "1", required = true)
    private String field;
    
    @Option(names = {"-d", "--delimiter"}, description = "The delimiter (tab by default)", defaultValue = "\t", required = false)
    private String delimiter;

    @Override //cut -f1,2 -d, D:\Projects\coding_challenges\cut-tool\fourchords.csv
    public void run() {
        
    	List<Integer> fieldsList = Stream.of(field.split("[,\\s]+")).map(Integer::parseInt).collect(Collectors.toList());
    	System.out.println(fieldsList);
    	
//    	if(Integer.parseInt(field) < 0) {
//    		System.err.println("Field number must be greater than or equal to 0");
//    		return;
//    	}
    	
    	//int numField = Integer.parseInt(field);
    	
    	try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
    		String line;
    		
    		while((line = reader.readLine()) != null){
    			String [] fields = line.split(delimiter);
    			
    			List<String> mappedFields = fieldsList.stream()
    				.filter(f -> f <= fields.length)
    					.map(f -> fields[f-1])
    					.collect(Collectors.toList());
    			
    			System.out.println(mappedFields);
    			
//    			if(fields.length >= numField) {
//    				System.out.println(fields[numField - 1]);
//    			} else {
//    				System.out.println();
//    			}
    		}
    		
    	} catch (FileNotFoundException e) {
    		System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
    }
}

