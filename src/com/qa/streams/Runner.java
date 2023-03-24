package com.qa.streams;

import java.util.List;
import java.util.stream.Collectors;

public class Runner {

	public static void main(String[] args) {

		List<String> names = List.of("Michael", "Dean", "James", "Chris");
		names.stream().forEach(x -> System.out.println("Hello " + x));

//		The above could actually be done without converting to a stream
//		as below
		names.forEach(x -> System.out.println(x));
//		or using a method reference:
		names.stream().forEach(System.out::println);

		System.out.printf("%nFiltered: %n");
		List<String> result = names.stream().filter(str -> !str.equals("James")).collect(Collectors.toList());
		result.forEach(System.out::println);

//		Combine filter and for each?
		System.out.printf("%nFiltered and combined: %n");
//		Can't use a method reference as we need to add "Hello "
		names.stream().filter(str -> !str.equals("James")).forEach(x -> System.out.println("Hello " + x));

//		Given the following List of Integers, using a stream, 
//		have it reduce and print the product (all numbers multiplied together).
		List<Integer> nums = List.of(3, 4, 7, 8, 12);
//		Anything within the reduce method () is an Accumulator
//		which means that it takes two parameters, a partial result
//		of the reduction operation, and the next element in the stream.
//		(accumulator, next) ->
		System.out.printf("%nReduce to product:%n");
		System.out.println(nums.stream().reduce((a, b) -> a * b).get());
//		get() is necessary to return the optional return

//		Starting with a list of numbers, use streams to do the following:
//		Find the max value.
		System.out.printf("%nReduce to max:%n");
		System.out.println(nums.stream().reduce((a, b) -> Math.max(a, b)).get());
//		Using a method reference as we have (a,b) on both sides of the lambda accumulator
		System.out.printf("%nReduce to max (method ref):%n");
		System.out.println(nums.stream().reduce(Math::max).get());

//		Find the min value
		System.out.printf("%nReduce to min:%n");
		System.out.println(nums.stream().reduce((a, b) -> Math.min(a, b)).get());
//		Remove the odd numbers
		System.out.printf("%nRemove the odd numbers:%n");
		nums.stream().filter(a -> a % 2 == 0).forEach(System.out::println);
//		Remove the even numbers
		System.out.printf("%nRemove the even numbers:%n");
		nums.stream().filter(a -> a % 2 != 0).forEach(System.out::println);
//		Sum the list
		System.out.printf("%nSum of the list:%n");
		System.out.println(nums.stream().reduce((a, b) -> a + b).get());

//		Square every number in the list then remove the 
//		even numbers and then find the min value
		System.out.printf("%nSquared numbers:%n");
		List<Integer> sqNums = nums.stream().map(x -> x * x).collect(Collectors.toList());
		sqNums.forEach(System.out::println);
		System.out.printf("%nSquared numbers without evens:%n");
		nums.stream().map(x -> x * x).filter(a -> a % 2 != 0).forEach(System.out::println);
		System.out.printf("%nSquared numbers without evens, reduced to min:%n");
		System.out.println(nums.stream().map(x -> x * x).filter(a -> a % 2 != 0).reduce(Math::min).get());
	}
}
