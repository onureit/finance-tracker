package olzhas.nurseit.spring.daos;

import olzhas.nurseit.spring.models.Transaction;
import olzhas.nurseit.spring.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

@Component
public class TransactionDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TransactionDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Transaction> index(int userId) {
        return jdbcTemplate.query(
                "SELECT id, user_id, amount, description, created_at " +
                        "FROM transactions WHERE user_id = ? ORDER BY created_at DESC",
                (rs, rowNum) -> { // didnt get fully
                    Transaction t = new Transaction();
                    t.setId(rs.getInt("id"));
                    t.setUserId(rs.getInt("user_id"));
                    t.setAmount(rs.getInt("amount"));
                    t.setDescription(rs.getString("description"));

                    Timestamp ts = rs.getTimestamp("created_at");
                    if (ts != null) t.setCreatedAt(ts.toLocalDateTime());

                    return t;
                },
                userId
        );
    }

    public void save(Transaction t){
        jdbcTemplate.update(
                "INSERT INTO transactions (user_id, amount, description) VALUES (?, ?, ?)",
                t.getUserId(),
                t.getAmount(),
                t.getDescription()
        );
    }

    public void update(int id, Transaction t){
        jdbcTemplate.update(
                "UPDATE transactions SET amount = ?, description = ? WHERE id = ?",
                t.getAmount(),
                t.getDescription(),
                id
        );
    }

    public void delete(int id){
        jdbcTemplate.update(
                "delete from transactions where id=?",
                id
        );
    }
}
