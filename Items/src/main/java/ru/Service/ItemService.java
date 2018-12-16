package ru.Service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import ru.DAO.ItemDAOImpl;

import java.util.List;

@Service
public class ItemService {

    private ItemDAOImpl itemDAO;

    @Autowired
    public ItemService(ItemDAOImpl itemDAO) {
        this.itemDAO = itemDAO;
    }

    public String getCostByItemsID(String IDs) {
        return itemDAO.getCostByItemsID(IDs);
    }

    public List<String> getPricesByItemsID(String IDs) {
        return itemDAO.getPricesByItemsID(IDs);
    }
}
