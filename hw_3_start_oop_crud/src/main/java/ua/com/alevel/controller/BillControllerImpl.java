package ua.com.alevel.controller;

import ua.com.alevel.entity.Bill;
import ua.com.alevel.service.BillService;
import ua.com.alevel.service.BillServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BillControllerImpl implements BillController {

    private final BillService billService = new BillServiceImpl();

    @Override
    public void start() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to the your first crud application");
        System.out.println("Select options:");
        String select;
        menu();
        while ((select = bf.readLine()) != null) {
            crud(bf, select);
        }
    }

    private void menu() {
        System.out.println();
        System.out.println("If you want create bill, please enter 1");
        System.out.println("If you want update bill, please enter 2");
        System.out.println("If you want delete bill, please enter 3");
        System.out.println("If you want find bill, please enter 4");
        System.out.println("If you want find all bills, please enter 5");
        System.out.println("If you want close, please enter 0");
    }

    private void crud(BufferedReader reader, String select) throws IOException {
        switch (select) {
            case "1" -> create(reader);
            case "2" -> update(reader);
            case "3" -> delete(reader);
            case "4" -> findById(reader);
            case "5" -> findAll();
            case "0" -> System.exit(0);
        }
        menu();
    }

    @Override
    public void create(BufferedReader reader) throws IOException {
        System.out.println("enter your first name:");
        String firstName = reader.readLine();
        System.out.println("enter your last name:");
        String lastName = reader.readLine();
        System.out.println("enter sum:");
        long sum = Long.parseLong(reader.readLine());
        Bill bill = new Bill();
        bill.setFirstName(firstName);
        bill.setLastName(lastName);
        bill.setSum(sum);
        billService.create(bill);
    }

    @Override
    public void update(BufferedReader reader) throws IOException {
        System.out.println("enter id");
        String id = reader.readLine();
        System.out.println("enter new first name:");
        String firstName = reader.readLine();
        System.out.println("enter new last name:");
        String lastName = reader.readLine();
        System.out.println("enter new sum:");
        long sum = Long.parseLong(reader.readLine());
        Bill bill = billService.findById(id);
        bill.setFirstName(firstName);
        bill.setLastName(lastName);
        bill.setSum(sum);
        billService.update(bill);
    }

    @Override
    public void delete(BufferedReader reader) throws IOException {
        System.out.println("enter bill id that you want to delete: ");
        String id = reader.readLine();
        billService.delete(id);
    }

    @Override
    public void findById(BufferedReader reader) throws IOException {
        Bill bill = billService.findById(reader.readLine());
        if (bill == null) {
            System.out.println("no bill");
        } else {
            System.out.println(bill);
        }
    }

    @Override
    public void findAll() {
        Bill[] bills = billService.findAll();
        for (Bill bill : bills) {
            System.out.println(bill);
        }
    }
}
