# Phone Suggester - Modern Phone Recommendation System

A modern, scalable phone recommendation application built with Spring Boot 3 and React. This application provides intelligent phone suggestions based on user preferences and requirements.

## 🚀 Features

- **RESTful API** with OpenAPI/Swagger documentation
- **In-memory mode** for local development (no database or Redis required!)
- **Spring Security** for API protection
- **Validation** with comprehensive error handling
- **Pagination** and sorting support
- **Health checks** and monitoring with Actuator
- **Modern React UI** with Tailwind CSS

## 🛠️ Technology Stack

- **Java 21**
- **Spring Boot 3.2.5**
- **React 18** (served from `/src/main/resources/static/index.html`)
- **Maven**

## 📋 Prerequisites

- Java 21 or higher
- Maven 3.8+

## 🚀 Quick Start (Local Development)

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd phone-suggester-maven
   ```

2. **Run the application**
   ```bash
   mvn clean spring-boot:run
   ```

   > The app runs in **in-memory mode** by default. No MongoDB or Redis is required for local testing!

3. **Access the application**
   - Frontend: [http://localhost:8081](http://localhost:8081)
   - API Documentation: [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)

## 📚 API Documentation

See [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html) after starting the app.

## 🏗️ Project Structure

```
phone-suggester-maven/
├── src/
│   ├── main/
│   │   ├── java/com/example/phonesuggester/
│   │   │   ├── config/           # Configuration classes
│   │   │   ├── controller/       # REST controllers
│   │   │   ├── dto/             # Data Transfer Objects
│   │   │   ├── exception/       # Exception handlers
│   │   │   ├── model/           # Entity models
│   │   │   ├── repository/      # Data access layer
│   │   │   ├── service/         # Business logic
│   │   │   └── PhoneSuggesterApplication.java
│   │   └── resources/
│   │       ├── static/          # Frontend assets
│   │       └── application.properties
│   └── test/                    # Test files
├── pom.xml                     # Maven dependencies
└── README.md                   # This file
```

## 🧪 Testing

Run all tests:
```bash
mvn test
```

## 📝 License

This project is licensed under the MIT License.

---

**Built with ❤️ using modern Java and React technologies** 