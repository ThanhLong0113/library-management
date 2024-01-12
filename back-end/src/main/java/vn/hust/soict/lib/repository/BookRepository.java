package vn.hust.soict.lib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.hust.soict.lib.entity.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
