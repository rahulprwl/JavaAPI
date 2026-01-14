# JavaAPI

## Prerequisites

- Java 25 or higher
- Maven 3.6+
- MongoDB running locally or accessible via connection string

## Running the Project

1. **Clone the repository**

   ```bash
   git clone <repository-url>
   cd JavaAPI
   ```

2. **Configure MongoDB Connection**

   Update `application.yml` with your MongoDB connection details:

   ```properties
   spring.mongodb.host=mongodb://localhost:27017
   spring.mongodb.port=<<PORT>>
   ```

3. **Configure Kafka Settings**

   Update `application.yaml` with your Kafka broker details:

   ```yaml
   spring:
     kafka:
       bootstrap-servers: localhost:9092
       consumer:
       group-id: javaapi-group
       auto-offset-reset: earliest
       producer:
       key-serializer: org.apache.kafka.common.serialization.StringSerializer
       value-serializer: org.springframework.kafka.support.serializer.JsonSerializer
   ```

4. **Configure Gemini Settings**

   Add your Gemini API credentials to `application.yml`:

   ```properties
   gemini.api.key=<your-api-key>
   ```

5. **Build the Project**

   ```bash
   mvn clean install
   ```

6. **Run the Application**

   ```bash
   mvn spring-boot:run
   ```

   The application will start on `http://localhost:8080`

## API Documentation

Once the application is running, access the Swagger UI:

- **Swagger UI**: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui.html)
- **API Docs**: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

## Troubleshooting

- Ensure MongoDB is running and accessible
- Check connection string in configuration file
- Verify Java version compatibility
