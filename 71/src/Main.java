/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GIA KHANH
 */
public class Main {

    public static void main(String[] args) {
        Validation v = new Validation();
        Manager m = new Manager();
        int choice;
        do {
            System.out.println("1. Add task");
            System.out.println("2. Delete task");
            System.out.println("3. Display Task");
            System.out.println("4. Exit");
            choice = v.getInt("Input your choice: ", 1, 4);
            switch (choice) {
                case 1:
                    m.addTask();
                    break;
                case 2:
                    m.deleteTask();
                    break;
                case 3:
                    m.showTask();
                    break;
                case 4:
                    break;
            }
        } while (choice != 4);
    }
}
