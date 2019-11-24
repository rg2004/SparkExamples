package com.practice.spark;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Helper {
	
    
    @Autowired
    SparkConf sparkConf;
    
    
    public void print() {
    	

      JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);
      
      List<Integer>  list = Arrays.asList(1,4,5,10);
      
      JavaRDD<Integer> listRDD = sparkContext.parallelize(list,2);
      
      listRDD.foreach(f-> System.out.println(f));
  }

}
