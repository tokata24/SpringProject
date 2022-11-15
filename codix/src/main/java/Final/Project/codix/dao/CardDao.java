package Final.Project.codix.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Repository
@Transactional
public class CardDao {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public CardDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void createCard(Map<String, Object> card) {
//card.setName(card.getName());
//card.setPosition(card.getPosition());
//card.setText(card.getText());

        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("Name", card.get("Name"))
                .addValue("Position", card.get("Position"))
                .addValue("Text", card.get("Text"));

        String sql = ""
                + "INSERT INTO CARDS1 ("
                + "Name,"
                + "Position,"
                + "Text)"
                + "VALUES ("
                + ":Name,"
                + ":Position,"
                + ":Text)";
        namedParameterJdbcTemplate.update(sql, params);

    }
}
