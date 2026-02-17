package olzhas.nurseit.spring.models;

import javax.validation.constraints.NotNull;

public class Category {
    private int id;

    @NotNull(message = "The name of the category required")
    private String name;

}
