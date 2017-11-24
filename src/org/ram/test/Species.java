package org.ram.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Species {

    private static final String SPACE = " ";

    static class Animal {
        String name;
        String type;
        int legs;
    }

    static class Mammal extends Animal {
        int foods;
        List<String> foodList;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animals = new ArrayList<>();
        List<Mammal> mammals = new ArrayList<>();
        captureInfo(scanner, animals, mammals);
        printInfo(animals, mammals);
    }

    private static void printInfo(List<Animal> animals, List<Mammal> mammals) {
        animals.forEach(animal -> System.out.println(animal.name + SPACE + animal.legs));
        mammals.forEach(mammal -> {
            System.out.println(mammal.name + SPACE + mammal.legs);
            System.out.println(mammal.type);
            System.out.print(mammal.foods + ":" + SPACE);
            mammal.foodList.forEach(food -> System.out.print(food + SPACE));
            System.out.println("");
        });
    }

    private static void captureInfo(Scanner scanner, List<Animal> animals, List<Mammal> mammals) {
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            captureAnimalInfo(scanner, type, animals);
            captureMammalInfo(scanner, type, mammals);
        }
    }

    private static void captureAnimalInfo(Scanner scanner, String type, List<Animal> animals) {
        if ("A".equalsIgnoreCase(type)) {
            Animal animal = new Animal();
            animal.name = scanner.next();
            animal.legs = scanner.nextInt();
            animals.add(animal);
        }
    }

    private static void captureMammalInfo(Scanner scanner, String type, List<Mammal> mammals) {
        if ("M".equalsIgnoreCase(type)) {
            Mammal mammal = new Mammal();
            mammal.name = scanner.next();
            mammal.type = scanner.next();
            int foods = scanner.nextInt();
            mammal.foodList = new ArrayList<>();
            for (int i = 0; i < foods; i++) {
                mammal.foodList.add(scanner.next());
            }
            mammal.foods = mammal.foodList.size();
            mammal.legs = 4;
            mammals.add(mammal);
        }
    }
}
