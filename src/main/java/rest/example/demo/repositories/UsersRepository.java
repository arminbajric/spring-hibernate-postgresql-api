package rest.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import rest.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends CrudRepository<User,Long> {
    List<User> getAllBy();
}
