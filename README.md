# PeepPeaLibrarian - Book Management System

[![Demo Video](https://img.shields.io/badge/demo-video-red.svg)](https://youtu.be/NtrUC_iPvn8)
[![GitHub](https://img.shields.io/badge/github-repo-blue.svg)](https://github.com/DrewErskine/SpringBoot-Java21-MySQL-Thymeleaf-Docker.Example)

## Demo

[![PeepPeaLibrarian Demo](https://img.youtube.com/vi/NtrUC_iPvn8/0.jpg)](https://youtu.be/NtrUC_iPvn8)

Click the image above to watch the demonstration video.

A sophisticated book tracking application built with Spring Boot 3 and Java 21, designed to help readers organize and manage their personal library. This application allows users to create book lists, add detailed notes to books they've read, mark favorites, and efficiently search through their collection by author or title.

## Features

- **Book Management**
  - Add books to personal reading lists
  - Track reading progress
  - Mark books as favorites
  - Add personal notes and reviews

- **Search Functionality**
  - Search by book title
  - Search by author name
  - Filter favorites

- **Modern Tech Stack**
  - Built with Spring Boot 3 and Java 21
  - Responsive Thymeleaf templates
  - MySQL 8 database
  - Containerized with Docker
  - AWS ECS deployment-ready

## Technology Stack

- **Java 21** - Latest LTS version with enhanced features
- **Spring Boot 3.3.1** - Modern web application framework
- **MySQL 8.3** - Robust database system
- **Thymeleaf** - Server-side Java template engine
- **Docker & Docker Compose** - Containerization and orchestration
- **Maven** - Dependency management and build automation

## Project Structure

### Core Components

#### 1. Controllers

##### HomeController (`HomeController.java`)
- **Endpoints**:
  - `GET /`: Home page with search interface

##### BookController (`BookController.java`)
- **Endpoints**:
  - `GET /books`: List all books
  - `GET /books/{id}`: View book details
  - `GET /books/add`: Display add book form
  - `POST /books`: Create new book
  - `GET /books/update/{id}`: Display update form
  - `POST /books/update/{id}`: Update existing book

#### 2. Models

##### Book Entity (`Book.java`)
- **Properties**:
  - `id`: Long - Unique identifier (Auto-generated)
  - `title`: String - Book title
  - `author`: String - Book author
- **JPA Annotations**:
  - `@Entity`: Marks as JPA entity
  - `@Id`: Primary key
  - `@GeneratedValue`: Auto-increment strategy

#### 3. Repository

##### BookRepository (`BookRepository.java`)
- Extends `JpaRepository<Book, Long>`
- Provides standard CRUD operations
- Supports custom query methods

### Frontend Assets

#### CSS Styles
- `accents.css`: Accent colors and highlights
- `accessories.css`: UI component styles
- `background.css`: Background styles
- `darkmode.css`: Dark theme support

#### JavaScript
- `script.js`: Client-side functionality
  - Search feature implementation
  - Dynamic UI updates
  - Form handling

#### Templates
- `index.html`: Home page with search
- `list.html`: Book list view
- `add.html`: Add book form
- `bookDetail.html`: Detailed book view

### Database Configuration

#### SQL Scripts
- `01-schema.sql`: Database schema definition
- `02-data.sql`: Initial data population

#### Properties
```properties
# Database Configuration
spring.jpa.hibernate.ddl-auto=none
spring.sql.init.mode=always
spring.datasource.url=jdbc:mysql://${DB_HOST:localhost}:3306/${DB_NAME:peeppea_booksDB}
```

## Getting Started

### Local Development

1. **Clone the Repository**
   ```bash
   git clone https://github.com/DrewErskine/SpringBoot-Java21-MySQL-Thymeleaf-Docker.Example
   cd SpringBoot-Java21-MySQL-Thymeleaf-Docker.Example
   ```

2. **Build the Application**
   ```bash
   mvn clean package
   ```

3. **Run with Docker Compose**
   ```bash
   docker compose up
   ```

The application will be available at `http://localhost:8080`

### Docker Commands

#### Container Management
```bash
# View running containers
docker ps

# Access MySQL container
docker exec -it peeppea.books-db mysql -u root -p

# View application logs
docker logs peeppea.books-container

# Stop all containers
docker compose down
```

#### Maintenance
```bash
# Remove stopped containers
docker container prune

# Clean up unused images
docker image prune

# List all images
docker images

# Remove specific container
docker rm <container_id>
```

## AWS Deployment

### 1. ECR Setup
1. Create an ECR repository at [AWS ECR Console](https://console.aws.amazon.com/ecr/home)

2. Authenticate with ECR:
   ```bash
   aws ecr get-login-password --region <your_region> | docker login --username AWS --password-stdin <your_account_id>.dkr.ecr.<your_region>.amazonaws.com
   ```

3. Tag and Push Image:
   ```bash
   docker tag peeppea.books-image:latest <your_account_id>.dkr.ecr.<your_region>.amazonaws.com/peeppeabooks:latest
   docker push <your_account_id>.dkr.ecr.<your_region>.amazonaws.com/peeppeabooks:latest
   ```

### 2. ECS Deployment
Create an ECS cluster through the [AWS ECS Console](https://console.aws.amazon.com/ecs/home) and follow the setup wizard to deploy your container.

## Contributing

Feel free to submit issues and enhancement requests!

## License

This project is open-source and available under the [MIT License](LICENSE).