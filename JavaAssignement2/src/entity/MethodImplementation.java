package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MethodImplementation {

	public static Map<String, Long> getCount(List<Candidate> list) {
		Map<String, Long> countMap = new HashMap<>();
		long mc = 0;
		long fc = 0;

		for (Candidate candidate : list) {
			if ("Male".equals(candidate.getGender())) {
				mc++;
			} else if ("Female".equals(candidate.getGender())) {
				fc++;
			}
		}

		countMap.put("Male", mc);
		countMap.put("Female", fc);
		return countMap;
	}

	public static Map<String, Double> getAverageAge(List<Candidate> list) {
		Map<String, Integer> ageSumMap = new HashMap<>();
		Map<String, Integer> countMap = new HashMap<>();

		for (Candidate candidate : list) {
			String gender = candidate.getGender();
			int age = candidate.getAge();

			ageSumMap.put(gender, ageSumMap.getOrDefault(gender, 0) + age);
			countMap.put(gender, countMap.getOrDefault(gender, 0) + 1);
		}

		Map<String, Double> avgAgeMap = new HashMap<>();
		for (String gender : ageSumMap.keySet()) {
			double average = (double) ageSumMap.get(gender) / countMap.get(gender);
			avgAgeMap.put(gender, average);
		}

		return avgAgeMap;
	}

	public static Map<String, Long> countCandidatesDepartmentWise(List<Candidate> list) {
		Map<String, Long> departmentCountMap = new HashMap<>();

		for (Candidate candidate : list) {
			String department = candidate.getDepartment();
			departmentCountMap.put(department, departmentCountMap.getOrDefault(department, 0L) + 1);
		}

		return departmentCountMap;
	}

	public static Candidate getYoungestCandidateDetails(List<Candidate> list) {
		if (list == null || list.isEmpty()) {
			return null;
		}

		Candidate youngest = list.get(0);
		for (Candidate candidate : list) {
			if (candidate.getAge() < youngest.getAge()) {
				youngest = candidate;
			}
		}
		return youngest;
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
