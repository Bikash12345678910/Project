package CrudOperation.crudoperationbackend.Service;

import CrudOperation.crudoperationbackend.Dao.UserDao;
import CrudOperation.crudoperationbackend.Dto.ResponseStructure;
import CrudOperation.crudoperationbackend.Entity.Users;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    // save user
    public ResponseEntity<ResponseStructure<Users>> saveuser(Users users){
        Users u=userDao.saveUsers(users);

        ResponseStructure rs=new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.OK.value());
        rs.setMessage("Successfully save the data");
        rs.setData(u);

        return new  ResponseEntity<>(rs,HttpStatus.OK);
    }

    //Fetch Users

    public ResponseEntity<ResponseStructure<List<Users>>> fetchusers(){
        List<Users> u=userDao.fetchUsers();
        ResponseStructure rs=new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.OK.value());
        rs.setMessage("Successfully fetch data");
        rs.setData(u);

        return new ResponseEntity<>(rs,HttpStatus.OK);
    }

    // Fetch single user

    public ResponseEntity<ResponseStructure<Users>> fetchuser(int id){
        Optional<Users> u=userDao.fetchuser(id);
        ResponseStructure<Users> rs=new ResponseStructure<>();
        if(u.isPresent()){
        rs.setStatusCode(HttpStatus.OK.value());
        rs.setMessage("Successfully fetch the single user");
        rs.setData(u.get());
            return new ResponseEntity<>(rs,HttpStatus.OK);
        }
        else {
            rs.setStatusCode(HttpStatus.NOT_FOUND.value());
            rs.setMessage("Not fetch the data");
            rs.setData(null);
            return new ResponseEntity<>(rs,HttpStatus.NOT_FOUND);
        }

    }

    // update single user

    public ResponseEntity<ResponseStructure<Users>> updateuser(int id,Users users){
        Optional<Users> u=userDao.updateUser(id,users);
        ResponseStructure<Users> rs=new ResponseStructure<>();
        if(u.isPresent()){
            rs.setStatusCode(HttpStatus.OK.value());
            rs.setMessage("successfully update the data");
            rs.setData(u.get());

            return  new ResponseEntity<>(rs,HttpStatus.OK);
        }
        else{
            rs.setStatusCode(HttpStatus.NOT_FOUND.value());
            rs.setMessage("ERROR update the data");
            rs.setData(null);

            return  new ResponseEntity<>(rs,HttpStatus.NOT_FOUND);
        }
    }
    // DELETE the user

    public ResponseEntity<ResponseStructure<Users>> deleteuser(int id){
        Optional<Users> u=userDao.fetchuser(id);
        ResponseStructure<Users> rs=new ResponseStructure<>();
        if(u.isPresent()){
            userDao.deleteUser(id);
            rs.setStatusCode(HttpStatus.OK.value());
            rs.setMessage("successfully delete the data");
            rs.setData(u.get());

            return new ResponseEntity<>(rs,HttpStatus.OK);
        }
        else{
            rs.setStatusCode(HttpStatus.NOT_FOUND.value());
            rs.setMessage("Error the delete the data");
            rs.setData(null);
            return  new ResponseEntity<>(rs,HttpStatus.NOT_FOUND);
        }

    }
}
