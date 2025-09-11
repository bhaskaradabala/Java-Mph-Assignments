package entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamsImplementation {
	
	public static Map<String, Long> getCount(List<Candidate> list){
		Map<String, Long> map =new  HashMap<>();
		long mc = list.stream().filter(s -> s.getGender().equals("Male")).count();
		long fc = list.stream().filter(s -> s.getGender().equals("Female")).count();
		
		map.put("Male",mc);
		map.put("Female",fc);
		return map;
		
	}
	
	public static Map<String, Double> getAverageAge(List<Candidate> list){
		Map<String, Double> map = list.stream()
				.collect(Collectors.groupingBy(
						Candidate::getGender, 
						Collectors.averagingInt(Candidate::getAge)));
		
		return map;
	}
	
	public static Map<String, Long> countCandidatesDepartmentWise(List<Candidate> list){
		Map<String, Long> map = list.stream()
				.collect(Collectors.groupingBy(
						Candidate::getDepartment,Collectors.counting()));
				
		return map;
	}
	    
	public static Optional<Candidate> getYoungestCandidateDetails(List<Candidate> list){
		 return list.stream()
			        .min(Comparator.comparingInt(Candidate::getAge));
		
	}
	
	
	
	
	
	
	
	public static void main(String args[]) {
		ArrayList<Candidate> cl = new ArrayList<>();
		cl.add(new Candidate("Prakash", 101, 22, "Male", "IT", 2020, 50000.00));
		cl.add(new Candidate("Surya", 102, 25, "Male", "Non IT", 2018, 75000.00));
		cl.add(new Candidate("Greeshmika", 103, 28, "Female", "IT", 2016, 95000.00));
		cl.add(new Candidate("Geethika", 107, 33, "Female", "Non IT", 2017, 35000.00));
		cl.add(new Candidate("Josam", 105, 30, "Male", "IT", 2023, 650000.00));
		cl.add(new Candidate("Bhaskar", 109, 22, "Male", "IT", 2012, 95000.00));
		cl.add(new Candidate("Catharien", 111, 28, "Female", "Non IT", 2018, 35000.00));
		cl.add(new Candidate("Chaitanya", 110, 23, "Male", "IT", 2015, 75000.00));
		cl.add(new Candidate("Harshitha", 108, 26, "Female", "IT", 2017, 85000.00));
		
		
		System.out.println(getCount(cl));
		System.out.println(getAverageAge(cl));
		System.out.println(countCandidatesDepartmentWise(cl));
		System.out.println(getYoungestCandidateDetails(cl));
		
		
	}

}
