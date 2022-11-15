package Final.Project.codix.service;

import Final.Project.codix.dao.CardDao;
import Final.Project.codix.model.Card;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CardService {
    private final CardDao cardDao;

    public CardService(CardDao cardDao) {
        this.cardDao = cardDao;
    }

    public void createCard(Map<String , Object> card){
        cardDao.createCard(card);
//card.getCardID();
//card.getName();
//card.getPosition();
//card.getText();
    }
}
