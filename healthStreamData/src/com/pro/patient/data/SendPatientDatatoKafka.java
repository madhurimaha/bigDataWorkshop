package com.pro.patient.data;

import static com.pro.patient.data.GeneratePatientInfo.generateAge;
import static com.pro.patient.data.GeneratePatientInfo.generateAilmentHistory;
import static com.pro.patient.data.GeneratePatientInfo.generateAllergies;
import static com.pro.patient.data.GeneratePatientInfo.generateDiagnosis;
import static com.pro.patient.data.GeneratePatientInfo.generateGender;
import static com.pro.patient.data.GeneratePatientInfo.generatePatientId;
import static com.pro.patient.data.GeneratePatientInfo.generateSymptoms;

import java.util.Random;

public class SendPatientDatatoKafka {

	public static void main(String[] args) throws InterruptedException {

			while (true) {
				
				int records = new Random().nextInt(15);
				for (int i = 1; i <= records; i++) {
					PatientInfo  patientInfo = new PatientInfo();
					patientInfo.setPatientId(generatePatientId());
					patientInfo.setPatientAge(generateAge());
					patientInfo.setPatientGender(generateGender());
					patientInfo.setAllergies(generateAllergies());
					patientInfo.setAilmentHistory(generateAilmentHistory());
					patientInfo.setSymptoms(generateSymptoms());
					patientInfo.setDiagnosis(generateDiagnosis());
					 
					
				 SimpleKafkaProducer.sendDataToKafkaSingleBroker(patientInfo.toString(),"patientInfo");
					//System.out.println(patientInfo);
				}
				
				
				System.out.println("Written " + records + " to Kafka..");
				Thread.sleep(3000);
			}



	}

}
