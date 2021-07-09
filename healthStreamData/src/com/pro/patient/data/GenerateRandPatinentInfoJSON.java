package com.pro.patient.data;

import com.pro.patient.data.PatientInfo.*;

import static com.pro.patient.data.GeneratePatientInfo.generatePatientId;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

public class GenerateRandPatinentInfoJSON {

	public static void main(String[] args) throws InterruptedException, IOException{
		while (true) {
			File file = new File("/Users/madhurim/eclipse-workspace/healthStreamData/simuldata/patient.json");
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			int records = new Random().nextInt(7);
			for (int i = 1; i <= records; i++) {
				PatientInfo  patientInfo = new PatientInfo();
				PatientInfo.setPatientId(generatePatientId());
				PatientInfo.setPatientAge(generateAge());
				PatientInfo.setPatientGender(generateGender());
				PatientInfo.setAllergies(generateAllergies());
				PatientInfo.setAilmentHistory(generateAilmentHistory());
				PatientInfo.setSymptoms(generateSymptoms());
				PatientInfo.setDiagnosis(generateDiagnosis());
				 
				
				bw.append(PatientInfo.toString() + "\n");
			}
			System.out.println("written " + records + " to the file. ");
			bw.flush();
			bw.close();
			Thread.sleep(2000);
		}

	}
	

}
