package com.java8.realtime;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Java8Solving {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// List<Employee> employeeList = new ArrayList<Employee>();
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

		
		// find the highest salary each department
		
		Map<String, Optional<Employee>> dMap=employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
		dMap.entrySet().forEach(s->{
			System.out.println(s.getKey()+""+s.getValue());
		});
		//System.out.println("dMap: "+dMap);
		
		List<Employee> das=employeeList.stream().sorted((s1,s2)->s1.getAge()-s2.getAge()).collect(Collectors.toList());
		das.forEach(s->{
			//System.out.println("Name: "+s.getName()+" "+": "+s.getAge());
		});
		//System.out.println("da :"+das);
		// employeeList.stream().filter(s->s.getAge()
		// >27).forEach(s->System.out.println(s.getAge()+"..."+s.getName()));
		// System.out.print(employeeList);

		/*
		 * employeeList.stream().filter(s -> s.getDepartment() == "Product Development")
		 * .collect(Collectors.groupingBy(Employee::getName)).entrySet().forEach(x -> {
		 * System.out.println(x.getValue() + " "); System.out.print(" " + x.getKey());
		 * });
		 */
		
		//2nd highest salary
		Optional<Double> secSal=employeeList.stream().map(Employee::getSalary).sorted(Comparator.reverseOrder()).skip(1).findFirst();
		System.out.println("2nd highest salary: "+ secSal);
		
		List<Employee> dep = employeeList.stream().filter(s -> s.getDepartment() == "Infrastructure")
				.collect(Collectors.toList());
		// System.out.println(dep);

		// System.out.print(el);

		// count the male and female employee
		Map<String, Long> m = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

		// System.out.println(m);

		// list out all the departments in this list.
		List<String> dds = employeeList.stream().map(e -> e.getDepartment()).collect(Collectors.toList());
		// System.out.println(dds);

		// find out the maximum salary every department
		Map<String, Optional<Employee>> dss = employeeList.stream().collect(Collectors
				.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
		dss.entrySet().forEach(ent -> {
			// System.out.println(ent.getKey() + ":" + ent.getValue());
		});
		//System.out.print(dss);

		Map<String, Long> ma = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		// System.out.println(ma);
		Optional<Employee> msa = employeeList.stream().max(Comparator.comparing(Employee::getSalary));

		// System.out.println(msa);
		// find out the all the departments

		List<String> le = employeeList.stream().map(e -> e.getDepartment()).collect(Collectors.toList());

		// System.out.println(le);

		// Sales And Marketing male and female count
		Map<String, Long> lsl = employeeList.stream().filter(s -> s.getDepartment() == "Sales And Marketing")
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		// System.out.println(lsl);

		// Those are joining after 2015
		// List<Employee> lii =employeeList.stream().filter(s->s.getYearOfJoining() >
		// 2015).collect(Collectors.toList());

		Map<String, Long> lii = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

		// find out the employee greater then 30 age

		List<Employee> eee = employeeList.stream().filter(s -> s.getAge() > 30).collect(Collectors.toList());

		// System.out.println(eee);

		// employeeList.stream().forEach(System.out::println);
		// employeeList.stream().for

		// employeeList.stream().sorted().forEach(Employee::getName);

		// How many male and female employees are there in the organization?
		Map<String, Long> countGend = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

		// System.out.println(countGend);

		// Print the name of all departments in the organization?
		// employeeList.stream().map(e->e.getDepartment()).distinct().forEach(System.out::println);
		// employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

		// What is the average age of male and female employees?

		Map<String, Double> avgAge = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
		// System.out.println(avgAge);

		// employee in the organization?

		Optional<Employee> da = employeeList.stream().max(Comparator.comparing(Employee::getSalary)); //
		Employee ddsr = da.get();
		// System.out.println(ddsr.getSalary());

		Optional<Employee> highestPaidEmployeeWrapper = employeeList.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
		Employee highestPaidEmployee = highestPaidEmployeeWrapper.get();

		// System.out.print(highestPaidEmployee.getSalary());

		// Get the names of all employees who have joined after 2015?
		// employeeList.stream().filter(e -> e.getYearOfJoining() >
		// 2015).forEach(System.out::println);

		// Count the number of employees in each department?

		/*
		 * 
		 * Map<String, Long> countDept = employeeList.stream()
		 * .collect(Collectors.groupingBy(Employee::getDepartment,
		 * Collectors.counting()));
		 */

		employeeList.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

		// What is the average salary of each department?

		Map<String, Double> aveSal = employeeList.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		// System.out.println(aveSal);

		// Get the details of youngest male employee in the product development
		// department?

		Optional<Employee> youngestMaleEmployeeInProductDevelopmentWrapper = employeeList.stream()
				.filter(e1 -> e1.getGender().equalsIgnoreCase("male")
						&& e1.getDepartment().equalsIgnoreCase("product development"))
				.min(Comparator.comparingInt(Employee::getAge));
		// System.out.println(youngestMaleEmployeeInProductDevelopmentWrapper);

		// Who has the most working experience in the organization?

		Optional<Employee> expr1 = employeeList.stream().sorted(Comparator.comparing(Employee::getYearOfJoining))
				.findFirst();

		// System.out.println(expr1);

		// How many male and female employees are there in the sales and marketing team?

		Map<String, Long> maleFe = employeeList.stream()
				.filter(e1 -> e1.getDepartment().equalsIgnoreCase("Sales And Marketing"))
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		// System.out.println(maleFe);

		// What is the average salary of male and female employees?
		Map<String, Double> avgSal = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
		// System.out.println(avgSal);

		Map<String, List<Employee>> dae = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		// System.out.println("dae: "+dae);

		Map<String, List<Employee>> d = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		 //System.out.println("depart :"+d);

		// List down the names of all employees in each department?
		
		Map<String, List<String>> departName=employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));
		departName.entrySet().forEach(s->{
			//System.out.print(s.getKey()+","+s.getValue()+" ");
			//System.out.print(s.getValue());
		});
		//System.out.println("all Departments Name:"+ departName);
		
		Map<String, List<Employee>> de = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		de.entrySet().forEach(ent -> {
			 System.out.println(ent.getKey());
		});
		// System.out.println("..."+de);

		DoubleSummaryStatistics allSal = employeeList.stream()
				.collect(Collectors.summarizingDouble(Employee::getSalary));
		// System.out.println(allSal);

		// System.out.println(ddd);

		// Who is the oldest employee in the organization? What is his age and which
		// department he belongs to?

		Optional<Employee> oldEmp = employeeList.stream().max(Comparator.comparingInt(Employee::getAge));
		// System.out.println(oldEmp);

		 //System.out.println("employee age is: " + oldEmp.get().getAge());

	}

}
