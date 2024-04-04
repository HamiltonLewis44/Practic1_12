/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pr_1_12;

/**
 *
 * @author andre
 */

import java.io.*;
import java.util.Scanner;

public class Pr_1_12 implements Externalizable {
    private String name;
    private String type;
    private int age;
    private double height;
    private boolean isIndoorPlant;

    public Pr_1_12() {
    }

    public void fillFields() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter plant name:");
        this.name = scanner.nextLine();
        System.out.println("Enter plant type:");
        this.type = scanner.nextLine();
        System.out.println("Enter plant age:");
        this.age = scanner.nextInt();
        System.out.println("Enter plant height:");
        this.height = scanner.nextDouble();
        System.out.println("Is it an indoor plant? (true/false):");
        this.isIndoorPlant = scanner.nextBoolean();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeObject(type);
        out.writeInt(age);
        out.writeDouble(height);
        out.writeBoolean(isIndoorPlant);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        type = (String) in.readObject();
        age = in.readInt();
        height = in.readDouble();
        isIndoorPlant = in.readBoolean();
    }

    public static void main(String[] args) {
        Pr_1_12 plant = new Pr_1_12();
        plant.fillFields();

        try {
            FileOutputStream fileOut = new FileOutputStream("C:\\Users\\andre\\plant.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(plant);
            out.close();
            fileOut.close();
            System.out.println("Plant object has been serialized and saved to C:/plant.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

