/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Short71xxx150;

import java.util.ArrayList;

/**
 *
 * @author DAOTHAOVAN1
 * 
 */
public class Main {

    public static void main(String[] args) {
        int id = 0;
        ArrayList<Task> listTask = new ArrayList<>();
        while (true) {
            int choice = Manager.displayMenu();
            switch (choice) {
                case 1:
                    Manager.addTask(listTask, ++id);
                    break;
                case 2:
                    Manager.deleteTask(listTask,id );
                    id--;
                    break;
                case 3:
                    Manager.displayTask(listTask);
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }
}
