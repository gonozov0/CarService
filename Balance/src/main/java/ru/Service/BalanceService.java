package ru.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.DAO.BalanceDAOImpl;

@Service
public class BalanceService {

    private BalanceDAOImpl balanceDAO;

    @Autowired
    public BalanceService(BalanceDAOImpl balanceDAO) {
        this.balanceDAO = balanceDAO;
    }

    public String balance(int user_id) {
        return balanceDAO.getBalanceByUserID(user_id);
    }

    public void updateUserBalance(double newBalance, int user_id) {
        balanceDAO.updateUserBalance(newBalance, user_id);
    }
    
}
