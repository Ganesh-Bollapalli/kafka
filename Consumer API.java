1) Properties props = new Properties();

props.put("bootstrap.servers", "localhost:9092");

props.put("group.id", "CountryCounter");

props.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");

props.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");

KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);


2) consumer.subscribe(Collections.singletonList("customerCountries"));


3)  try 
        {
          while (true)
          {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records)
            {
              System.out.println("topic = "+record.topic()+ 
              "partition = "+record.partition()+ 
              "offset = "+record.offset()+ 
              "customer = "+record.key()+ 
              "country = "+record.value());
            }
          }
        } 
        finally
        {
          consumer.close();
        }

PARAMETERS :

fetch.min.bytes
fetch.max.wait.ms
max.partition.fetch.bytes
session.timeout.ms
partition.assignment.strategy(Range, Round Robin, StickyAssignor, CooperativeStickyAssignor)