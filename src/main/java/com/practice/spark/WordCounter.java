package com.practice.spark;

import java.util.Arrays;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import scala.Tuple2;

/*@Order(value=1)
@Component*/
public class WordCounter implements CommandLineRunner {
	
	    @Value("${inputFile}")
	    private String fileName;

	  
	 
	     public static void main(String[] args) {
	    	  
	    	  SpringApplication.run(WordCounter.class, args);
	    
	    }
	
    private static void wordCount(String fileName) {

        SparkConf sparkConf = new SparkConf().setMaster("local").setAppName("JD Word Counter");

        JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);

        JavaRDD<String> inputFile = sparkContext.textFile(fileName);

        JavaRDD<String> wordsFromFile = inputFile.flatMap(content -> Arrays.asList(content.split(" ")));

        JavaPairRDD countData = wordsFromFile.mapToPair(t -> new Tuple2(t, 1)).reduceByKey((x, y) -> (int) x + (int) y);

        countData.saveAsTextFile("CountData");
    }


	@Override
	public void run(String... args) throws Exception {
		System.out.println(" args"+args);
		System.out.println("invokin word count with file name!!"+fileName);
		 wordCount(fileName);
		
	}
}
