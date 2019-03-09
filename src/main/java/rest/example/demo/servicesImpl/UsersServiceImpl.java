package rest.example.demo.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;

import rest.example.demo.TableModels.users;
import org.springframework.stereotype.Service;
import rest.example.demo.TableRepositories.UsersRepository;
import rest.example.demo.services.UserService;

import java.util.List;
@Service
public class UsersServiceImpl implements UserService {
    @Autowired
   private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<users> getAll() {
        return usersRepository.getAllBy();
    }

    @Override
    public void create(users user) {
         usersRepository.save(user);
    }

    @Override
    public users checkUserForLogin(String user_email, String password) {
        return usersRepository.findByEmailAndPassword(user_email,password);
    }

    @Override
    public users getUser(String email) {
        return usersRepository.findByEmail(email);
    }
}
