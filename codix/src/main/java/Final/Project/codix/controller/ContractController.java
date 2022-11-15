package Final.Project.codix.controller;


import Final.Project.codix.model.Card;
import Final.Project.codix.model.Contract;
import Final.Project.codix.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ContractController {
    @Autowired
    private ContractService contractService;


    @PostMapping(path = "/addContract")
    public void createContract(@RequestBody Map<String , Object> contract){
        contractService.createContract(contract);
    }
    @PostMapping(path = "/changeCard")
    public void changeCard(@RequestBody Contract contract, Card card, int id){
contractService.changeCard(contract,card,id);
    }
}
