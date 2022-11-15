package Final.Project.codix.service;

import Final.Project.codix.dao.ContractDao;
import Final.Project.codix.model.Card;
import Final.Project.codix.model.Contract;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ContractService {
    private final  ContractDao contractDao;

    public ContractService(ContractDao contractDao) {
        this.contractDao = contractDao;
    }


    public void createContract(Map<String , Object>  contract){
contractDao.createContract(contract);
    }
    public void changeCard(Contract contract, Card card, int id){
        contractDao.changeCard(contract,card,id);
    }
}
