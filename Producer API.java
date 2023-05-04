Creating a Producer using Java API involves three steps:

1) Creating a Producer Object with all the properties we want to pass to the Producer.
2) Creating a ProducerRecord Object which has the name of the topic, key and value of the record we want to send to the Broker.
3) Sending the ProducerRecord Object to the Kafka Broker using Producer Object's send() method.


1) Properties kafkaProps = new Properties();
kafkaProps.put("bootstrap.servers","localhost:9092");
kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
kafkaProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

KafkaProducer<String, String> producer = new KafkaProducer<String, String>(kafkaProps);


2) ProducerRecord<String, String> record = new ProducerRecord<>("CustomerCountry", "Precision Products","France");


3)  producer.send(record);

PARAMETERS:

buffer.memory
compression.type
retries
ack=0/1/all

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


package tcs.fresco.play;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class TheProducer {
    public static void main(String args[]) {
        produceMessages();
    }
    public static void produceMessages(){
        String topic = "MyTopic"; //Use this topic.
        //Run install once before executing your code
        //Write your code here...
        Properties kafkaProps = new Properties();
kafkaProps.put("bootstrap.servers","localhost:9092");
kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
kafkaProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
KafkaProducer<String, String> producer = new KafkaProducer<String, String>(kafkaProps);
ProducerRecord<String, String> record = new ProducerRecord<>(topic, "Hello","Hello");
producer.send(record);       
    }
} 