package com.java8.realtime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Tesing3 {

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

		// employeeList.stream().forEach(System.out::println);
		// employeeList.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);

		// 2nd higest salary value
		List<Double> sorteList = employeeList.stream().map(Employee::getSalary).sorted(Comparator.reverseOrder())
				.skip(1).collect(Collectors.toList());
		// System.out.println("sorteList: "+sorteList.get(0));

		List<Double> empSal = employeeList.stream().map(s -> s.getSalary()).sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		// System.out.println("2nd salary:" + empSal.get(0));

		// find the highest salary each department
		Map<String, Optional<Employee>> highestsalDepart = employeeList.stream().collect(Collectors
				.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
//		System.out.println("highest Salary each Department:"+highestsalDepart);

		// sort based on salary/name/age/yearOfJoining...
		employeeList.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
		// employeeList.stream().sorted(Comparator.comparing(Employee::getYearOfJoining)).forEach(System.out::println);;

		// What is the average salary of male and female employees?
		Map<String, Double> avgSalGe = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
		// System.out.println("avarge salary gender: "+ avgSalGe);

		// find out the maximum salary every department
		Map<String, Optional<Employee>> maxSalDept = employeeList.stream().collect(Collectors
				.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
		// System.out.println("maxSalDept :"+ maxSalDept);

		// What is the average salary of each departmen
		Map<String, Double> deptAvgSal = employeeList.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		// System.out.println("avarge salary dept: "+ deptAvgSal);

		// How many male and female employees are there in the sales and marketing team?

		List<Employee> sortedEmp = employeeList.stream().sorted(Comparator.comparing(Employee::getYearOfJoining))
				.collect(Collectors.toList());
		System.out.println(sortedEmp.get(1));

		Map<String, Long> gendSalMartDept = employeeList.stream()
				.filter(s -> s.getDepartment().equalsIgnoreCase("sales and marketing"))
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		// System.out.println("gendSalMartDept :"+gendSalMartDept);

		// Who has the most working experience in the organization?
		Optional<Employee> hisempAge = employeeList.stream().max(Comparator.comparing(Employee::getAge));
		// System.out.println("highest age emp: "+hisempAge);

		

		// Get the details of youngest male employee in the product development
		Optional<Employee> dt = employeeList.stream().filter(s -> s.getDepartment() == "Product Development" && s.getGender()=="Female")
				.collect(Collectors.maxBy(Comparator.comparing(Employee::getAge)));
		//System.out.println("dt :" + dt);
		
		Optional<Employee> d = employeeList.stream()
				.filter(s -> s.getDepartment().equalsIgnoreCase("product development"))
				.collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
		//System.out.println("d :" + d);

		// Print the name of all departments in the organization?
		List<String> allDepart = employeeList.stream().map(Employee::getDepartment).distinct()
				.collect(Collectors.toList());
		// System.out.println("All department: "+ allDepart);

		// What is the average salary of each department
		Map<String, Double> avgSal = employeeList.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		// System.out.println("avgSal :" + avgSal);

		// Count the number of employees in each department?
		Map<String, Long> countdep = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		// System.out.println("count department:" + countdep);

		// find out the employee greater then 30 age
		// employeeList.stream().filter(s->s.getAge()>30).forEach(System.out::println);

		// How many male and female employees are there in the organization?
		Map<String, Long> genderCountMap = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		// System.out.println("Male and Female Count:"+ genderCountMap);

		// What is the average age of male and female employees?
		Map<String, Double> avgGenderMap = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
		// System.out.println("avagrage age gender: "+avgGenderMap);

		// Get the names of all employees who have joined after 2015?
		// employeeList.stream().filter(s->s.getYearOfJoining()>2015).forEach(System.out::println);

		// List down the names of all employees in each department?
		Map<String, List<String>> departName = employeeList.stream().collect(Collectors
				.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));
		/*
		 * departName.entrySet().forEach(s -> { //
		 * System.out.print(s.getKey()+","+s.getValue()+" "); //
		 * System.out.print(s.getValue()); });
		 */
		// System.out.println("all Departments Name:"+ departName);
		
		
		// Who is the oldest employee in the organization? What is his age and which
		// department he belongs to?

		Optional<Employee> oldEmp = employeeList.stream().min(Comparator.comparing(Employee::getYearOfJoining));
		// System.out.println("Old Employee and name is: "+oldEmp.get().getName()+", age
		// is:"+oldEmp.get().getAge()+", department is:
		// "+oldEmp.get().getDepartment()+", year of
		// joining:"+oldEmp.get().getYearOfJoining());

	}

}
