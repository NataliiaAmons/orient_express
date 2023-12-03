package com.TextGame.dao;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;
import java.util.ArrayList;

public abstract class ClueRepository<ClueType> {

    protected abstract ClueType createInstance(String[] data);

    public ClueType getItemFromFile(int number, String fileName) throws IOException {
        ClueType item = createInstance(new String[0]);

        Resource resource = new ClassPathResource("static/" + fileName);
        File file = resource.getFile();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if (Integer.valueOf(data[0]) == number) {
                    item = createInstance(data);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    protected abstract int getNumFromItem(ClueType item);

    public ArrayList<ClueType> getAllItems(String fileName) throws IOException {
        ArrayList<ClueType> allItems = new ArrayList<>();
        int num = 1;
        while (true) {
            ClueType item = getItemFromFile(num, fileName);
            if (getNumFromItem(item) != num) {
                break;
            }
            else {
                allItems.add(item);
                num++;
            }
        }
        return allItems;
    } 
}