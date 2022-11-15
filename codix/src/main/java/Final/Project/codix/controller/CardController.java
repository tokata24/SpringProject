package Final.Project.codix.controller;


import Final.Project.codix.model.Card;
import Final.Project.codix.model.Contract;
import Final.Project.codix.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CardController {
    @Autowired
    private CardService cardService;


    @PostMapping(path = "/addCard")
    public void createCard(@RequestBody Map<String, Object> card) {
        cardService.createCard(card);
    }
}
