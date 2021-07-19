package com.pro.patient.data;

import java.util.*;

public class GeneratePatientInfo {

	public static void main(String[] args) {
		for (int i = 1; i <= 4; i++) {

			System.out.println("PatientId:" + generatePatientId());

			System.out.println("Gender:" + generateGender());

			System.out.println("Age:" + generateAge());

			System.out.println("Allergies:" + generateAllergies());

			System.out.println("Ailment History:" + generateAilmentHistory());

			System.out.println("Symptoms :" + generateSymptoms());

			
			System.out.println("Diagnosis :" + generateDiagnosis());

			System.out.println("----------------------------");

		}

	}
	
	public static String generatePatientId() {
		return UUID.randomUUID().toString();
	}
	
	public static String generateGender() {
		String[] GenderArray = { "Male", "Female", "Other" };
		return GenderArray[new Random().nextInt(GenderArray.length)];
	}
	public static int generateAge() {
		return new Random().nextInt(100);
	}
	public static String generateAllergies(){
		String[] AllergyArray = { "Penicillin", "Sulpha", "Iodine" ,"Food","Others","None"};
		return AllergyArray [new Random().nextInt(AllergyArray .length)];
	}
	
	public static String generateAilmentHistory(){
		String[] AilmentHistoryArray = { "Diabetes", "Hypertension", "Hypothyrodism" ,"Arthritis"};
		return AilmentHistoryArray[new Random().nextInt(AilmentHistoryArray.length)];
	}
	
	public static String generateSymptoms(){
		String[] SymptomsArray = { "Fatigue","Breathing difficulty","Weight Change", "Insomnia" ,"Fever","Chills","Halitosis","Nausea"};
		return SymptomsArray [new Random().nextInt(SymptomsArray .length)];
	}
	
	public static String generateDiagnosis(){
		String[] DiagnosisArray = { "Hypertension", "Fibromyalgia", "Asthma" ,"Urinary tract infection","Osteoarthritis","Cancer"};
		return DiagnosisArray [new Random().nextInt(DiagnosisArray .length)];
	}
}
