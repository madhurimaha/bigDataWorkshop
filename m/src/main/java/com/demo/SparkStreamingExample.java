package com.demo;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.storage.StorageLevel;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.StreamingContext;
import org.apache.spark.streaming.dstream.ReceiverInputDStream;

public class SparkStreamingExample {

	public static void main(String[] args) {
		SparkConf conf = new SparkConf().setAppName("SparkStreamingExample").setMaster("local[*]");
		Duration duration=new Duration(5000);

		StreamingContext ssc=new StreamingContext(conf,duration);
		
	ReceiverInputDStream<String> lines = ssc.socketTextStream("localhost",8000,StorageLevel.MEMORY_AND_DISK());
	 
	System.out.println("Count"+lines.count());
	ssc.start();
	ssc.awaitTermination();

	}

}
