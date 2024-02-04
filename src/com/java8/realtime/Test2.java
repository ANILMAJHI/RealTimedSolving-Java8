package com.java8.realtime;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Test2 {

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

		// find the highest salary each department
		Map<String, Optional<Employee>> dds = employeeList.stream().collect(Collectors
				.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
		dds.forEach((de, sal) -> {
			// System.out.println("deparatment: " + de + ",salary:" +
			// sal.get().getSalary());
		});
		
		//this is the new line for check git testing
		employeeList.stream().forEach(System.out::println);

		// System.out.println("dds" + dds);

		// find out the details who's department name is "Product Development"
		List<Employee> dep = employeeList.stream()
				.filter(s -> s.getDepartment().equalsIgnoreCase("Product Development")).collect(Collectors.toList());
		// List<Employee> dep = employeeList.stream().filter(s ->
		// s.getDepartment().equals("Product Development"))
		// .collect(Collectors.toList());
		// System.out.println("deparatement: "+ dep);

		// count the male and female employee
		/*
		 * Map<String, Long> mfcount = employeeList.stream()
		 * .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		 */
		// System.out.println("mfcount "+mfcount);

		// list out all the departments in this list.
		/*
		 * List<String>
		 * sl=employeeList.stream().map(Employee::getDepartment).distinct().collect(
		 * Collectors.toList()); System.out.println("sl"+sl);
		 */
		List<String> dempar = employeeList.stream().map(s -> s.getDepartment()).distinct().collect(Collectors.toList());
		// List<String> dempar = employeeList.stream().map(s ->
		// s.getDepartment()).distinct().collect(Collectors.toList());
		// System.out.println("dep name; "+dempar);

		//highest salary
		// Optional<Employee>
		// higS=employeeList.stream().max(Comparator.comparing(Employee::getSalary));

		// count the depart
		Map<String, Long> coD = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		// System.out.println(coD);

		// Sales And Marketing male and female count
		Map<String, Long> d = employeeList.stream()
				.filter(s -> s.getDepartment().equalsIgnoreCase("Sales And Marketing"))
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		// System.out.println(d);

		// Those are joining after 2015
		//List<Employee> joining = employeeList.stream().filter(s -> s.getYearOfJoining() > 2015).map(s -> s)
			//	.collect(Collectors.toList());
		List<String> joining = employeeList.stream().filter(s -> s.getYearOfJoining() > 2015).map(s -> s.getDepartment()+":"+s.getYearOfJoining())
				.collect(Collectors.toList());
		 System.out.println("joining "+joining);

		// find out the employee greater then 30 age

		// List<Employee> agEmployees
		// =employeeList.stream().filter(s->s.getAge()>30).map(s->s).collect(Collectors.toList());
		List<String> agEmployees = employeeList.stream().filter(s -> s.getAge() > 30)
				.map(s -> s.getDepartment() + "," + s.getName() + "," + s.getAge() + ".").collect(Collectors.toList());
		// System.out.println("agEmployees; " + agEmployees);
		// List<Employee>
		// age=employeeList.stream().filter(s->s.getAge()>30).collect(Collectors.toList());
		List<String> age1 = employeeList.stream().filter(s -> s.getAge() > 30).map(s -> s.getName() + "=" + s.getAge())
				.collect(Collectors.toList());
		List<Employee> age = employeeList.stream().map(s -> s).filter(s -> s.getAge() > 30)
				.collect(Collectors.toList());
		// System.out.println("age: " + age);

		// How many male and female employees are there in the organization?
		Map<String, Long> maleF = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		// System.out.println("male and female: "+maleF);

		// Print the name of all departments in the organization?
		List<String> alldep = employeeList.stream().map(s -> s.getDepartment()).distinct().collect(Collectors.toList());
		// System.out.println("all Dept: "+alldep);

		// What is the average age of male and female employees?
		Map<String, Double> avge = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
		// System.out.println("avage age: "+avge);

		Optional<Employee> amx = employeeList.stream().max(Comparator.comparing(Employee::getAge));
		// System.out.println("max age"+ amx);

		// Count the number of employees in each department?
		Map<String, Long> ld = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		// System.out.println(ld);

		// What is the average salary of each department?
		Map<String, Double> ave1 = employeeList.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		// System.out.println(ave1);

		employeeList.stream().filter(s -> s.getGender().equalsIgnoreCase("male") && s.getDepartment() == "product")
				.max(Comparator.comparing(Employee::getAge));

		// Get the details of youngest male employee in the product development
		Optional<Employee> dd1 = employeeList.stream()
				.filter(s -> s.getDepartment().equals("Product Development") && s.getGender().equalsIgnoreCase("male"))
				.min(Comparator.comparing(Employee::getAge));
		// System.out.println(dd1);

		// Who has the most working experience in the organization?
		Optional<Employee> aM = employeeList.stream().min(Comparator.comparing(Employee::getYearOfJoining));
		// System.out.println("aM :"+aM);
		Optional<Employee> empd = employeeList.stream().min(Comparator.comparing(Employee::getYearOfJoining));
		// Optional<Employee> empd =
		// employeeList.stream().sorted(Comparator.comparing(Employee::getYearOfJoining))
		// .findFirst();
		// System.out.println("empd: "+empd);

		// How many male and female employees are there in the sales and marketing team?
		Map<String, Long> dg = employeeList.stream()
				.filter(s -> s.getDepartment().equalsIgnoreCase("sales and marketing"))
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(dg);

		// What is the average salary of male and female employees?
		employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
		Map<String, Double> avsa = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
		// System.out.println(avsa);

		// how many female employees are there in sales and marketing team?

		Map<String, Long> deFEmployees = employeeList.stream()
				.filter(s -> s.getDepartment().equalsIgnoreCase("sales and marketing")
						&& s.getGender().equalsIgnoreCase("female"))
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		deFEmployees.entrySet().forEach(s -> {
			//System.out.println(s.getKey());
		});
		//System.out.println("deFEmployees: " + deFEmployees);

		Map<String, List<Employee>> dld = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		dld.entrySet().forEach(s -> {
			// System.out.println(s.getKey());
		});
		// System.out.print(dld);

	}

}
