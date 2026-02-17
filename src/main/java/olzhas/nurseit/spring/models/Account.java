package olzhas.nurseit.spring.models;


// this model will store how much money do i have right now


import javax.validation.constraints.NotNull;

public class Account {
    @NotNull(message = "Account name required")
    private String name; // the name of the money holding source
    private int balance;
    private int id;
    private int userId;



}
