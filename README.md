# Kafka Producer & Consumer with Spring Boot

This project demonstrates how to implement both a Kafka **Producer** and **Consumer** using **Spring Boot** in a single codebase. It uses JSON messages and leverages Spring Kafka's support for serialization and deserialization.

## 🧰 Technologies Used

- Java 17+
- Spring Boot 3.x
- Spring Kafka
- Apache Kafka
- Maven

## 📁 Project Structure
src
├── main
│ ├── java
│ │ └── com.example.kafka
│ │ ├── config
│ │ │ ├── KafkaProducerConfig.java
│ │ │ └── KafkaConsumerConfig.java
│ │ ├── dto
│ │ │ └── Customer.java
│ │ ├── producer
│ │ │ └── KafkaMessageProducer.java
│ │ └── consumer
│ │ └── KafkaMessageListener.java
│ └── resources
│ └── application.yml or application.properties
