package ua.com.alevel.service;

import ua.com.alevel.entity.Bill;

public interface BillService {

    void create(Bill bill);
    void update(Bill bill);
    void delete(String id);
    Bill findById(String id);
    Bill[] findAll();
}
