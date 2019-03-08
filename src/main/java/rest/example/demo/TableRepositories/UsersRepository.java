package rest.example.demo.TableRepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import rest.example.demo.TableModels.users;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<users,Long> {
    List<users> getAllBy();
    users findByEmailAndPassword(String email,String password);
    users findByEmail(String email);


}
