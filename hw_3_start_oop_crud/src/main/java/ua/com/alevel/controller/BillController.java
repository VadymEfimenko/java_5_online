package ua.com.alevel.controller;

import java.io.BufferedReader;
import java.io.IOException;

public interface BillController {

    void create(BufferedReader reader) throws IOException;

    void update(BufferedReader reader) throws IOException;

    void delete(BufferedReader reader) throws IOException;

    void findById(BufferedReader reader) throws IOException;

    void findAll();

    void start() throws IOException;
}
