package CrudOperation.crudoperationbackend.Controller;

import CrudOperation.crudoperationbackend.Dto.ResponseStructure;
import CrudOperation.crudoperationbackend.Entity.Users;
import CrudOperation.crudoperationbackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
    @Autowired
    private UserService userService;

    // Save user
    @PostMapping("/users")
    public ResponseEntity<ResponseStructure<Users>> saveuserController(@RequestBody Users users){
        return userService.saveuser(users);
    }

    // fetch all user

    @GetMapping("/fetch")
    public ResponseEntity<ResponseStructure<List<Users>>> fetchuserController(){
        return userService.fetchusers();
    }

    // fetch single user
    @GetMapping("/fetchSingle/{id}")
    public ResponseEntity<ResponseStructure<Users>> fetchuserController(@PathVariable int id){
        return userService.fetchuser(id);
    }

    // update user
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseStructure<Users>> updateuserController(@PathVariable int id,@RequestBody Users users){
        return userService.updateuser(id,users);
    }

    //delete user

    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity<ResponseStructure<Users>> deleteuserController(@PathVariable int id){
        return userService.deleteuser(id);
    }
}
