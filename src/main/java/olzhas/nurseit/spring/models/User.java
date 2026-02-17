package olzhas.nurseit.spring.models;

//will be some person who want to track their money

public class User {
    private String name;
    private int id;

    public User() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

}
