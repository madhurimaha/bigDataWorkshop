package com.demo;

import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.get_json_object;

import java.util.concurrent.TimeoutException;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.streaming.StreamingQueryException;

public class PatientSparkStructuredStreaming{
	
	public static void main(String[] args) throws InterruptedException, StreamingQueryException, TimeoutException
	{
		SparkConf conf = new SparkConf().setAppName("Patient-Spark-Structured-Streaming").setMaster("local[*]");
		SparkSession spark = SparkSession.builder().config(conf).getOrCreate();
		
		Dataset<Row> patientinfoDf = spark.readStream().format("kafka")
				  .option("kafka.bootstrap.servers", "localhost:9092,localhost:9093,localhost:9094")
				  .option("subscribe", "patient-info-kafka")
				  .load()
				  .selectExpr("CAST(key AS STRING)","CAST(value as string)")
				  .select(get_json_object(col("value"),"$.patientId").alias("patientId"),
						  get_json_object(col("value"),"$.patientAge").alias("patientAge"),
						  get_json_object(col("value"),"$.patientGender").alias("patientGender"),
						  get_json_object(col("value"),"$.allergies").alias("allergies"),
						  get_json_object(col("value"),"$.ailmentHistory").alias("ailmentHistory"),
						  get_json_object(col("value"),"$.symptoms").alias("symptoms"),
						  get_json_object(col("value"),"$.diagnosis").alias("diagnosis")
						  );
		
		Dataset<Row> cancerInfo = patientinfoDf.filter(col("diagnosis").equalTo("Cancer"));
		cancerInfo.writeStream().format("json")
		.option("checkpointLocation", 
				"/Users/madhurim/eclipse-workspace/healthStreamData/simulated-data/check-point-3")
		.option("path","/Users/madhurim/eclipse-workspace/healthStreamData/simulated-data/out/Oncologist").start()
		.awaitTermination();
		
	/*	
		Dataset<Row> asthamaInfo = patientinfoDf.filter(col("diagnosis").equalTo("Asthma"));
		asthamaInfo.writeStream().format("json")
		.option("checkpointLocation", 
				"/Users/madhurim/eclipse-workspace/healthStreamData/simulated-data/check-point")
		.option("path","/Users/madhurim/eclipse-workspace/healthStreamData/simulated-data/out/ENT").start()
		.awaitTermination();
		
		Dataset<Row> hypertensionInfo = patientinfoDf.filter(col("diagnosis").equalTo("Hypertension"));
		hypertensionInfo.writeStream().format("json")
		.option("checkpointLocation", 
				"/Users/madhurim/eclipse-workspace/healthStreamData/simulated-data/check-point")
		.option("path","/Users/madhurim/eclipse-workspace/healthStreamData/simulated-data/out/Cardiologist").start()
		.awaitTermination();
		
		Dataset<Row> fibromyalgiaInfo = patientinfoDf.filter(col("diagnosis").equalTo("Fibromyalgia"));
		fibromyalgiaInfo.writeStream().format("json")
		.option("checkpointLocation", 
				"/Users/madhurim/eclipse-workspace/healthStreamData/simulated-data/check-point")
		.option("path","/Users/madhurim/eclipse-workspace/healthStreamData/simulated-data/out/Rheumatologist").start()
		.awaitTermination();
		
		
		Dataset<Row> osteoarthritisInfo = patientinfoDf.filter(col("diagnosis").equalTo("Osteoarthritis"));
		osteoarthritisInfo.writeStream().format("json")
		.option("checkpointLocation", 
				"/Users/madhurim/eclipse-workspace/healthStreamData/simulated-data/check-point-2")
		.option("path","/Users/madhurim/eclipse-workspace/healthStreamData/simulated-data/out/Orthopedic").start()
		.awaitTermination();
		
		Dataset<Row> cancerInfo = patientinfoDf.filter(col("diagnosis").equalTo("Cancer"));
		cancerInfo.writeStream().format("json")
		.option("checkpointLocation", 
				"/Users/madhurim/eclipse-workspace/healthStreamData/simulated-data/check-point")
		.option("path","/Users/madhurim/eclipse-workspace/healthStreamData/simulated-data/out/Oncologist").start()
		.awaitTermination();
		
		
		Dataset<Row> utiInfo = patientinfoDf.filter(col("diagnosis").equalTo("Urinary tract infection"));
		utiInfo.writeStream().format("json")
		.option("checkpointLocation", 
				"/Users/madhurim/eclipse-workspace/healthStreamData/simulated-data/check-point")
		.option("path","/Users/madhurim/eclipse-workspace/healthStreamData/simulated-data/out/Urologist").start()
		.awaitTermination();	
		

	*/
	}
	
}


