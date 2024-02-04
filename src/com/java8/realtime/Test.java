package com.java8.realtime;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {

		List<Employee> employeeList = new ArrayList<Employee>();

		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

		//highest salary each departments
		Map<String, Optional<Employee>> las=employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
		
		System.out.println("highest salary each depat:"+ las);
		employeeList.stream().filter(s->s.getDepartment().equalsIgnoreCase("Product Development")).forEach(System.out::println);
		
		// employeeList.stream().forEach(System.out::println);

		// employeeList.stream().filter(s->s.getAge()>27).sorted(Comparator.comparingDouble(Employee::getSalary)).forEach(System.out::println);

		// System.out.println(r);

		// employeeList.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);
		Optional<Employee> eee1 = employeeList.stream().max(Comparator.comparing(Employee::getSalary));
		// System.out.println(eee1);

		Optional<Employee> el = employeeList.stream()
				.collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));

		List<Employee> el1 = employeeList.stream().sorted(Comparator.comparing(Employee::getSalary)).skip(1)
				.collect(Collectors.toList());

		// System.out.println("higest salary: " + el1.get(0));

		Map<String, Double> el2 = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
		// System.out.println(el2);

		/*
		 * 
		 * List<Employee> l
		 * =employeeList.stream().sorted(Comparator.comparingDouble(Employee::getSalary)
		 * ).skip(3).collect(Collectors.toList()); System.out.println(l.get(0));
		 */
		// employeeList.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));

		// employeeList.stream().sorted((e1, e2) ->
		// e1.getName().compareTo(e2.getName())).forEach(System.out::println);

		Map<String, Long> c = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

		// System.out.println(c);

		// Print the name of all departments in the organization?
		List<String> c1 = employeeList.stream().map((Employee::getDepartment)).distinct().collect(Collectors.toList());

		// System.out.println(c1);

		// What is the average age of male and female employees?

		// Map<String, Double> l1=
		// employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,
		// Collectors.averagingDouble(Employee::getAge)));

		// System.out.println(l1);

		// Get the names of all employees who have joined after 2015
		// employeeList.stream().filter(s->s.getYearOfJoining()>2015).forEach(System.out::println);

		// Count the number of employees in each department?
		Map<String, Long> e = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

		// System.out.println(e);

		//highest salary each department
		Map<String, Optional<Employee>> eS = employeeList.stream().collect(Collectors
				.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
		eS.entrySet().forEach(s -> {
			//System.out.println(s.getValue() + ": " + s.getValue());
		});
		System.out.println("eS: " + eS);

		// What is the average salary of each departmen
		Map<String, Double> av = employeeList.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		// System.out.println(av);

		// How many male and female employees are there in the sales and marketing team?
		Map<String, Long> me = employeeList.stream().filter(s -> s.getDepartment() == "Sales And Marketing")
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
//		System.out.println(me);

		// What is the average salary of male and female employees?
		Map<String, Double> ll = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
		// System.out.println(ll);

		// Print the name of all departments in the organization?

		List<String> st = employeeList.stream().map(s -> s.getDepartment()).distinct().collect(Collectors.toList());
		// System.out.println(st);
		// What is the average age of male and female employees?
		Map<String, Double> md = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));

		// System.out.println(md);
		// Get the details of highest paid employee in the organization?

		Optional<Employee> eee = employeeList.stream()
				.collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
		/*
		 * Employee e3=eee.get(); System.out.println(e3.getAge());
		 * System.out.println(e3.getDepartment()); System.out.println(e3.getSalary());
		 * 
		 */

// Get the names of all employees who have joined after 2015?

		List<String> eml1 = employeeList.stream().filter(s -> s.getYearOfJoining() > 2016)
				.map(name -> name.getName() + ", " + name.getDepartment() + ", " + name.getSalary())
				.collect(Collectors.toList());

		List<String> eml = employeeList.stream().filter(s -> s.getYearOfJoining() > 2017).map(s -> s.getName())
				.collect(Collectors.toList());
		// System.out.println("eml1 " + eml1);
		// Count the number of employees in each department?
		Map<String, Long> ee = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		Map<String, Long> ee1 = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

		// System.out.println(ee);
		// What is the average salary of each department?
		Map<String, Double> ms = employeeList.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

		// System.out.println(ms);
		// What is the average salary and total salary of the whole organization?
		// double
		// sal=employeeList.stream().collect(Collectors.averagingDouble(Employee::getSalary));
		DoubleSummaryStatistics tolSal = employeeList.stream()
				.collect(Collectors.summarizingDouble(Employee::getSalary));

		/*
		 * System.out.println("Ava Sal: "+tolSal.getAverage());
		 * System.out.println("Total Sal: "+tolSal.getSum());
		 */

		// Who is the oldest employee in the organization? What is his age and which
		// department he belongs to?

		Optional<Employee> age = employeeList.stream().max(Comparator.comparingInt(Employee::getAge));
		/*
		 * System.out.println(age);
		 * 
		 * Employee e2=age.get(); System.out.println(e2.getAge());
		 * System.out.println(e2.getName()); System.out.println(e2.getDepartment());
		 */

	}

}
