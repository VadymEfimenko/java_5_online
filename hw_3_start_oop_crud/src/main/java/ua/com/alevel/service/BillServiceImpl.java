package ua.com.alevel.service;

import ua.com.alevel.entity.Bill;

import java.util.UUID;

public class BillServiceImpl implements BillService {

    public Bill[] bills = new Bill[2];
    private int billsSummary = 0;

    public void create(Bill bill) {
        bill.setId(generateId());
        checkForRemoveNulls();
        checkIncreaseStorageSize();
        int storagePoint = checkEmptyStoragePoint();
        if (storagePoint >= 0) {
            bills[storagePoint] = bill;
        } else {
            bills[billsSummary] = bill;
        }
        billsSummary++;
    }

    public void update(Bill bill) {
        for (int i = 0; i < bills.length; i++) {
            try {
                if (bills[i].getId().equals(bill.getId())) {
                    bills[i] = bill;
                }
            } catch (Exception e) {
                i++;
            }
        }
    }

    public void delete(String id) {
        checkForRemoveNulls();
        for (int i = 0; i < bills.length; i++) {
            try {
                if (bills[i].getId().equals(id)) {
                    bills[i] = null;
                }
            } catch (Exception e) {
                i++;
            }
        }
        billsSummary--;
    }

    public Bill findById(String id) {
        for (int i = 0; i < bills.length; i++) {
            try {
                if (bills[i].getId().equals(id))
                    return bills[i];
            } catch (Exception e) {
                i++;
            }
        }
        return null;
    }

    public Bill[] findAll() {
        return bills;
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        for (Bill bill : bills) {
            if (bill != null && bill.getId().equals(id)) {
                return generateId();
            }
        }
        return id;
    }

    private void checkIncreaseStorageSize() {
        if (billsSummary == bills.length) {
            Bill[] newBillsStorage = new Bill[(int) (bills.length * 1.5) + 1];
            for (int i = 0; i < bills.length; i++) {
                newBillsStorage[i] = bills[i];
            }
            this.bills = newBillsStorage;
        }
    }

    private int checkEmptyStoragePoint() {
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == null) {
                return i;
            }
        }
        return -1;
    }

    private void removeNulls(){
        int size = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] != null){
                size++;
            }
        }
        Bill[] newBills = new Bill[size];
        int newBillsCounter = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] != null){
                newBills[newBillsCounter] = bills[i];
                newBillsCounter++;
            }
        }
        this.bills = newBills;
    }

    private void checkForRemoveNulls(){
        if (billsSummary == 0){
            System.out.println(billsSummary);
        } else if (bills.length/billsSummary == 2){
            removeNulls();
        }
    }
}
