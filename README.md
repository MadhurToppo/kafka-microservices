# kafka-microservices

# Kafka Microservices with Spring Boot

This project demonstrates a microservices architecture using Kafka for event-driven communication. All microservices are built with Spring Boot, ensuring rapid development and production-ready features.

## Features

- **Order Service**: Publishes order events to Kafka.
- **Inventory Service**: Consumes order events and updates inventory levels.
- **Notification Service**: Consumes order events and sends notifications to users.
- **Domains Module**: Provides shared domain models, including `Order` and `OrderEvent`, for consistent data structures across services.
- **Kafka Integration**: Uses Spring Kafka for seamless communication between services.
- **Event-Driven Architecture**: Demonstrates decoupled communication between microservices.
- **Spring Boot**: Simplifies microservice development with embedded servers and production-ready configurations.

## Project Structure

- `order-service`: Publishes order events to Kafka.
- `inventory-service`: Consumes order events from Kafka and manages inventory.
- `notification-service`: Consumes order events from Kafka and sends notifications.
- `domains`: Contains shared domain models used across services.

## Prerequisites

- Java 17 or higher
- Apache Kafka
- Maven

## How to Run

1. Start Kafka and Zookeeper.
2. Build the project using Maven:

   ```bash
   mvn clean install
   ```

3. Navigate to each microservice directory and run:

   ```bash
   mvn spring-boot:run
   ```

   This will start the respective microservice.

## Usage

- The `OrderProducer` class in the `Order Service` sends order events to the configured Kafka topic.
- The `Inventory Service` listens to order events and updates inventory levels accordingly.
- The `Notification Service` listens to order events and sends notifications to users.
- The `Domains Module` provides shared entities like `Order` and `OrderEvent` for consistent communication between services.
- Customize the Kafka topic and other configurations in the `application.properties` file of each service.

## License

This project is licensed under the Apache License, Version 2.0. See the [LICENSE](LICENSE) file for details.
