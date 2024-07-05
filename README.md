# Java

## BookController.java Methods
- `setBookRepository(BookRepository bookRepository)`: Sets the book repository.
- `getBook(Long id, Model model)`: Retrieves a book by its ID and adds it to the model.
- `getAllBooks(Model model)`: Retrieves all books and adds them to the model.
- `addBookForm(Model model)`: Prepares a model with a new book for adding.
- `createBook(Book book)`: Saves a new book.
- `updateBookForm(Long id, Model model)`: Prepares a model with a book for updating.
- `updateBook(Long id, Book book)`: Updates a book and saves it.

## Book.java Methods
- `getId()`: Returns the book ID.
- `setId(Long id)`: Sets the book ID.
- `getTitle()`: Returns the book title.
- `setTitle(String title)`: Sets the book title.
- `getAuthor()`: Returns the book author.
- `setAuthor(String author)`: Sets the book author.

## BookRepository.java Methods
- `findAll()`: Retrieves all books.
- `findById(Long id)`: Finds a book by ID.
- `save(Book book)`: Saves a book.

---

## A. Deploy :salute:

### 0. Clone the Repository: 
```git clone <https://github.com/DrewErskine/SpringBoot-Java21-Thymeleaf-Docker.Example>```
```cd <SpringBoot-Java21-Thymeleaf-Docker.Example>```

### 1: Build the Spring Boot JAR File: ```mvn clean package```

### 2: Build your Docker image: ```docker build -t peeppea.books-image .```

### 3: Run Docker Compose: ```docker-compose up```

## B. Create an ECR Repository - https://console.aws.amazon.com/ecr/home.

### 1: Authenticate Docker to Your Amazon ECR Registry: ```aws ecr get-login-password --region <your_region> | docker login --username AWS --password-stdin <your_account_id>.dkr.ecr.<your_region>.amazonaws.com```
- ``` aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 730335561704.dkr.ecr.us-east-1.amazonaws.com ```


### 2: Tag the Docker Image for ECR: ```docker tag peeppea.books-image:latest <your_account_id>.dkr.ecr.<your_region>.amazonaws.com/peeppeabooks:latest```
- ``` docker tag peeppea.books-image:latest 730335561704.dkr.ecr.us-east-1.amazonaws.com/peeppeabooks:latest ```

### 3: Push the Docker Image to ECR: ```docker push <your_account_id>.dkr.ecr.<your_region>.amazonaws.com/peeppeabooks:latest```
- ``` docker push 730335561704.dkr.ecr.us-east-1.amazonaws.com/peeppeabooks:latest ```

## C. Create an ECS Cluster - https://console.aws.amazon.com/ecr/home.



## Connecting to the Docker Containers :smiling_imp:

### Check Running Containers: ```docker ps```

### Access the MySQL Container: ```docker exec -it peeppea.books-db mysql -u <username> -p<password>```

### Access the Spring Boot Application Logs: ```docker logs peeppea.books-container```


## Stopping and Removing Containers :shaking_face:

### Stop All Running Containers: ```docker-compose down```

### Remove All Stopped Containers: ```docker container prune```

### docker image prune: ```docker image prune```

## Useful Docker Commands :sunglasses:

### List All Docker Images: ```docker images```

### Remove a Specific Docker Image: ```docker rmi <image_id>```

### List All Docker Containers (Running and Stopped): ```docker ps -a```

### Remove a Specific Docker Container: ```docker rm <container_id>```