package com.wyq.spark

import org.apache.spark.{SparkConf, SparkContext}

object HelloWorld {
  def main(args: Array[String]): Unit = {
    // 1. 创建一个SparkContext
    val conf = new SparkConf().setMaster("local").setAppName("HelloWorld")
    val sc = new SparkContext(conf)

    // 2. 从数据源得到一个RDD
    val path = this.getClass.getClassLoader.getResource("data/wordcount.txt").getFile
    val lineRDD = sc.textFile(path)
    // 3. 对RDD做各种转换
    val resultRDD = lineRDD.flatMap(_.split(","))
      .map((_, 1))
      .reduceByKey(_ + _)
    // 4. 执行一个行动操作
    val wordCountResult = resultRDD.collect()
    wordCountResult.foreach(println)

    // 5. 关闭SparkContext
    sc.stop
  }
}
