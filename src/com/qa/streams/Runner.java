package com.qa.streams;

import java.util.List;
import java.util.stream.Collectors;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> names = List.of("Michael", "Dean", "James", "Chris");
		names.stream().forEach(x -> System.out.println("Hello " + x));
		 
//		The above could actually be done without converting to a stream
//		as below
		names.forEach(x -> System.out.println(x));
//		or using a method reference:
		names.stream().forEach(System.out::println);
		
		System.out.printf("%nFiltered: %n");
		List<String> result = names.stream().filter(str -> !str.equals("James"))
				.collect(Collectors.toList());
		result.forEach(System.out::println); 
		
//		Combine filter and for each?
		System.out.printf("%nFiltered and combined: %n");
		names.stream().filter(str -> !str.equals("James")).forEach(System.out::println);
	}

}
