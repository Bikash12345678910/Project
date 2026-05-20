package CrudOperation.crudoperationbackend.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Users {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
    private String name;
    @Column(unique = true)
    private String email;
    private String role;
}
