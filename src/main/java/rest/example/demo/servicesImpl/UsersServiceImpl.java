package rest.example.demo.servicesImpl;

import rest.example.demo.models.User;
import org.springframework.stereotype.Service;
import rest.example.demo.repositories.UsersRepository;
import services.UserService;

import java.util.List;
@Service
public class UsersServiceImpl implements UserService {
   private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<User> getAll() {
        return usersRepository.getAllBy();
    }

    @Override
    public void create(User user) {
         usersRepository.save(user);
    }
}
