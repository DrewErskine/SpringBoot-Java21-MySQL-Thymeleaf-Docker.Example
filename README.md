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

## Deploy :salute:

### 1. Log in to AWS ECR: ```aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 730335561704.dkr.ecr us-east-1.amazonaws.com ```

### 12. Build your Docker image: ```docker build -t peeppeabooks .```

### 13. Tag your Docker image for ECR: ```docker tag peeppeabooks:latest 730335561704.dkr.ecr.us-east-1.amazonaws.com/peeppeabooks:latest```

### 14. Push your Docker image to ECR: ```docker push 730335561704.dkr.ecr.us-east-1.amazonaws.com/peeppeabooks:latest```