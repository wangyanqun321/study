package source

import java.util.Properties

import org.apache.flink.api.common.serialization.SimpleStringSchema
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer
import org.apache.flink.api.scala._

object kafkaSourceTest {
  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    val properties = new Properties()
    properties.setProperty("bootstrap.servers", "hadoop001:9092,hadoop002:9092,hadoop003:9092")
    properties.setProperty("group.id", "test")
    val stream = env.addSource(new FlinkKafkaConsumer[String]("wyq", new SimpleStringSchema(), properties))
    stream.print()
    env.execute("test kafka")
  }
}
