package CrudOperation.crudoperationbackend.Repository;

import CrudOperation.crudoperationbackend.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {
}
