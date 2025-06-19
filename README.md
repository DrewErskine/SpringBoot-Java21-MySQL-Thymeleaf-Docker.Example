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

- **Java 21**
- **Spring Boot 3.3.1**
- **MySQL 8.3**
- **Thymeleaf**
- **Docker & Docker Compose**
- **Maven**

## Project Structure

### Core Components

#### 1. Book Entity (`Book.java`)
- **Properties**:
  - `id`: Long - Unique identifier
  - `title`: String - Book title
  - `author`: String - Book author
- **Methods**:
  - Getters and setters for all properties

#### 2. Book Controller (`BookController.java`)
- **Endpoints**:
  - `GET /book/{id}`: Retrieve a specific book
  - `GET /books`: List all books
  - `GET /book/add`: Show add book form
  - `POST /book/create`: Create new book
  - `GET /book/update/{id}`: Show update form
  - `POST /book/update/{id}`: Update existing book

#### 3. Book Repository (`BookRepository.java`)
- Extends `JpaRepository`
- Provides database operations for Book entity

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