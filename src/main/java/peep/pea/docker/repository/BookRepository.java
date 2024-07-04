package peep.pea.docker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import peep.pea.docker.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
