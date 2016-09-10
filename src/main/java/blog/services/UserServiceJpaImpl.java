
package blog.services;

import blog.models.User;
import blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
/*import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;*/

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.*;

@Service
@Primary
public class UserServiceJpaImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public List<User> findAll() {
        return this.userRepo.findAll();
    }

    @Override
    public User findById(Long id) {
        return this.userRepo.findOne(id);
    }

    @Override
    public User create(User user) {
        // TODO: encrypt the password here
        /*user.setPasswordHash(bCryptPasswobrdEncoder.encode(user.getPasswordHash()));*/
        return this.userRepo.save(user);
    }

    @Override
    public User edit(User user) {
        return this.userRepo.save(user);
    }

    @Override
    public void deleteById(Long id) {
        this.userRepo.delete(id);
    }


    @Override
    public boolean authenticate(String username, String password) {
        // Provide a sample password check: username == password

        return Objects.equals(username, password);
        /*throw new UnsupportedOperationException("Operation not implemented");*/
    }

    @Override
    public User login(String username, String password) {

        throw new UnsupportedOperationException("Operation not implemented");
    }

    @Override
    public User register(String username, String password, String fullName) {
        throw new UnsupportedOperationException("Operation not implemented");
    }

    @Override
    public void setPassword(String username, String newPassword) {
        throw new UnsupportedOperationException("Operation not implemented");
    }

    @Override
    public User findByUsername(String username){
        return userRepo.findByUsername(username);
    }
}

