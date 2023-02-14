package ua.com.alevel;

import ua.com.alevel.controller.BillController;
import ua.com.alevel.controller.BillControllerImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        BillController billController = new BillControllerImpl();
        billController.start();
    }
}