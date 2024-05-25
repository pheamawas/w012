package test;

import delicacy.Dish;
import delicacy.Food;
import delicacy.Meat;
import delicacy.Noodle;
import exception.MyCheckedException;
import exception.MyUncheckedException;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Today's Topics");
        System.out.println("Exceptions");
        System.out.println("Decolator Design Patterns");
        System.out.println("Java IO");
//        demoNewException();
        demoDecolator();
    }

    private static void demoDecolator() {
        System.out.println("Demo Decolator Design Pattern");
        Dish d1 = Meat.addBeef(Noodle.RICE_NOODLE);
        Dish d2 = Meat.addPork(Meat.addBeef(Noodle.EGG_NOODLE));
        Dish d3 = new Meat(30, "Shrimp", new Noodle(20, "Bokk"));
        System.out.println("Dish4: " + d3.getPrice() + d3.ingredientsToString());

    }

    private static void demoNewException() {
        System.out.println("Demo New Exception");
        try {
            demoUncheckedException();
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> x = null;
        try {
            demoCheckedException();
            x = new LinkedList<>();
            x.add("abc");
        } catch (MyCheckedException e) {
            e.printStackTrace();
        } finally {
            if (x != null) x.clear();
        }
    }

    private static void demoUncheckedException() {
        throw new MyUncheckedException("Test Unchecked Exception");
    }

    private static void demoCheckedException() throws MyCheckedException {
        throw new MyCheckedException("Test Checked Exception");
    }
}
