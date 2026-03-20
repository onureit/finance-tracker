package olzhas.nurseit.spring.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "accounts")
@Entity
@Setter
@Getter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

}
