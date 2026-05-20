package CrudOperation.crudoperationbackend.Dao;

import CrudOperation.crudoperationbackend.Entity.Users;
import CrudOperation.crudoperationbackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class UserDao {

    @Autowired
    private UserRepository userRepository;

    // save the user
    public Users saveUsers(Users users){
        return userRepository.save(users);
    }

    // fetch all user

    public List<Users> fetchUsers(){
        return userRepository.findAll();
    }

    // fetch single user

    public Optional<Users> fetchuser(int id){
       return userRepository.findById(id);
    }

    // Update the user

    public Optional<Users> updateUser(int id, Users users) {

        Optional<Users> optionalUsers = userRepository.findById(id);

        if (optionalUsers.isPresent()) {

            Users user1 = optionalUsers.get();

            // Do not update ID
            user1.setName(users.getName());
            user1.setEmail(users.getEmail());
            user1.setRole(users.getRole());

            // Save updated data
            userRepository.save(user1);
        }

        return optionalUsers;
    }

    // delete the user

    public void deleteUser(int id){
        Optional<Users> optionalUsers=userRepository.findById(id);
        if(optionalUsers.isPresent()){
            userRepository.delete(optionalUsers.get());
        }
    }

}
