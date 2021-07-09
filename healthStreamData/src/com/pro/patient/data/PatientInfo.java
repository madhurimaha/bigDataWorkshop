package com.pro.patient.data;

import com.google.gson.Gson;

public class PatientInfo {

	
		private String patientId;
		private int patientAge;
		private String patientGender;
		private String allergies;
		private String ailmentHistory;
		private String symptoms;
		private String diagnosis;
		
		public PatientInfo(){
			
		}
		
		
		public PatientInfo(String patientId, int patientAge, String patientGender, String allergies,
				String ailmentHistory, String symptoms, String diagnosis) {
			super();
			this.patientId = patientId;
			this.patientAge = patientAge;
			this.patientGender = patientGender;
			this.allergies = allergies;
			this.ailmentHistory = ailmentHistory;
			this.symptoms = symptoms;
			this.diagnosis = diagnosis;
		}
		
		public String getPatientId() {
			return patientId;
		}
		public  void setPatientId(String patientId) {
			this.patientId = patientId;
		}
		public int getPatientAge() {
			return patientAge;
		}
		public void setPatientAge(int patientAge) {
			this.patientAge = patientAge;
		}
		public String getPatientGender() {
			return patientGender;
		}
		public void setPatientGender(String patientGender) {
			this.patientGender = patientGender;
		}
		public String getAllergies() {
			return allergies;
		}
		public void setAllergies(String allergies) {
			this.allergies = allergies;
		}
		public String getAilmentHistory() {
			return ailmentHistory;
		}
		public void setAilmentHistory(String ailmentHistory) {
			this.ailmentHistory = ailmentHistory;
		}
		public String getSymptoms() {
			return symptoms;
		}
		public void setSymptoms(String symptoms) {
			this.symptoms = symptoms;
		}
		public String getDiagnosis() {
			return diagnosis;
		}
		public void setDiagnosis(String diagnosis) {
			this.diagnosis = diagnosis;
		}
	
		@Override
		public  String toString() {
			Gson gson = new Gson();
			return gson.toJson(this);
		}
		
			

}
