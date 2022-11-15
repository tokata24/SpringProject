package Final.Project.codix.dao;

import Final.Project.codix.model.Card;
import Final.Project.codix.model.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class ContractDao {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public ContractDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
    public void createContract(Map<String , Object> contract) {

        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("TypeOFActivity", contract.get("TypeOFActivity"))
                .addValue("ListOfCards", contract.get("ListOfCards"));

        String sql = ""
                + "INSERT INTO CONTRACT ("
                +"TypeOfActivity,"
                +"ListOfCards)"
                + "VALUES ("
                + ":TypeOFActivity,"
                + ":ListOfCards)";
        namedParameterJdbcTemplate.update(sql, params);

    }
    // this method is not correct and needs full change 
    public void changeCard(Contract contract,Card card, int id){
        List<Card> cardList = contract.getCardList();
        for (int i = 0; i <cardList.size() ; i++) {
            if(cardList.get(i).getCardID() == id){

                cardList.remove(i);
                cardList.add(card);
                SqlParameterSource params = new MapSqlParameterSource()
                        .addValue("list", cardList);
                String sql = ""
                        +"ALTER TABLE Contract MODIFY ListOfCards = list";
                namedParameterJdbcTemplate.update(sql,params);

                System.out.println("card " + id + "was removed");
                System.out.println("card " + card.getCardID() + "was added");
            }
        }

    }
}
