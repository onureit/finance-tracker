    package olzhas.nurseit.spring.models;


    import javax.validation.constraints.Min;
    import javax.validation.constraints.NotEmpty;
    import javax.validation.constraints.NotNull;
    import javax.validation.constraints.Size;
    import java.time.LocalDate;
    import java.time.LocalDateTime;
    import java.util.Date;

    // it will store the information about the transactions

    public class Transaction {
        private int id;
        private int userId;
//        // i will need it to know from which source (account) the transaction was made
//        @NotNull(message="Account is required")
//        private Integer accountId;

        // to know which category of expenses or savings was made
//        @NotNull(message = "Category is required")
//        private Integer categoryId;

        @NotNull(message = "Amount of money is required")
        @Min(value = 0, message = "Amount of money cannot be negative")
        private Integer amount;

        private LocalDateTime createdAt;

        @Size(max = 255, message = "Description too long")
        private String description;

        public int getId() {
            return id;
        }

        public Integer getAmount() {
            return amount;
        }

        public int getUserId() {
            return userId;
        }

//        public Integer getCategoryId() {
//            return categoryId;
//        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public String getDescription() {
            return description;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

//        public void setCategoryId(Integer categoryId) {
//            this.categoryId = categoryId;
//        }

        public void setAmount(Integer amount) {
            this.amount = amount;
        }

        public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
