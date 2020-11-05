package ru.asd.data;

import java.util.List;

public class PrintDuplicate {
    public static void printDuplicate(List duplicate) {
        System.out.println("Found " + duplicate.size() + " duplicates:");
        for (int i = 0; i < duplicate.size(); i++) {
            System.out.println(i + 1 + ". " + duplicate.get(i));
        }
    }
}
