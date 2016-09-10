package blog.repositories;

import blog.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.util.*;



@Repository
public interface UserRepository extends
        JpaRepository<User, Long> {
        User findByUsername(String username);
}
/*this repository extends JpaRepository<User, Long> - that includes all CRUD operations*/
/*Create repository wich uses User by Id*/