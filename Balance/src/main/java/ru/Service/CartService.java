package ru.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.Balance;
import ru.DAO.CartDAOImpl;

import java.util.List;

@Service
public class CartService {

    private CartDAOImpl balanceDAO;

    @Autowired
    public CartService(CartDAOImpl balanceDAO) {
        this.balanceDAO = balanceDAO;
    }

    public List<Balance> balance() {
        return balanceDAO.getBalance();
    }

    public void updateUserBalance(double newBalance, int user_id) {
        balanceDAO.updateUserBalance(newBalance, user_id);
    }
    
}
