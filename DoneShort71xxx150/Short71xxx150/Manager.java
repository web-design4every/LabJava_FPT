/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Short71xxx150;

import java.util.ArrayList;

/**
 *
 * @author DAOTHAOVAN
 */
public class Manager {

    //Display Menu
    public static int displayMenu() {
        System.out.println("-----------Menu---------");
        System.out.println("1. Add Task");
        System.out.println("2. Delete Task");
        System.out.println("3. Display Task");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int choice = Validate.checkInputChoice(1, 4);
        return choice;
    }

    //Add Tasks
    public static void addTask(ArrayList<Task> listTask, int id) {
        System.out.print("Enter Requirement Name: ");
        String requirementName = Validate.checkInputString();
        System.out.print("Enter TaskTypeID: ");
        String taskTypeID = Validate.checkInputTaskTypeID(listTask, requirementName);

        System.out.print("Enter Date: ");
        String date = Validate.checkInputDate();
        System.out.print("Enter Plan From: ");
        String planFrom = Validate.checkInputPlan(1, 0);
        System.out.print("Enter Plan To: ");
        String planTo = Validate.checkInputPlan(2, Double.parseDouble(planFrom));
        System.out.print("Enter Assignee: ");
        String assignee = Validate.checkInputString();
        System.out.print("Enter Reiewer: ");
        String reviewer = Validate.checkInputString();
        Task t = new Task(id, taskTypeID, requirementName, date, planFrom, planTo, assignee, reviewer);
        listTask.add(t);

    }

    //Delete Task
    public static void deleteTask(ArrayList<Task> listTask, int id) {
        if (listTask.size() == 0) {
            System.out.println("Task is empty! Add more!");
            return;
        } else {
            System.out.print("Enter ID task to delete: ");
            int keyID = Validate.checkInputChoice(1, listTask.size());
            listTask.remove(keyID - 1);
            for (int i = keyID - 1; i < listTask.size(); i++) {
                listTask.get(i).setID(listTask.get(i).getID() - 1);
            }
            System.out.println("Delete successfully!");
        }
    }

    //Display List Task
    public static void displayTask(ArrayList<Task> listTask) {
        if (listTask.size() == 0) {
            System.out.println("Task is empty! Add more!");
            return;
        } else {
            System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n", "ID", "Name", "TaskTypeID", "Date", "Time", "Assignee", "Reviewer");
            for (int i = 0; i < listTask.size(); i++) {
                System.out.printf("%-5d%-15s%-15s%-15s%-15s%-15s%-15s\n",
                        listTask.get(i).getID(),
                        listTask.get(i).getRequirementName(),
                        listTask.get(i).getTaskTypeID(),
                        listTask.get(i).getDate(),
                        Double.parseDouble(listTask.get(i).getPlanTo()) - Double.parseDouble(listTask.get(i).getPlanFrom()),
                        listTask.get(i).getAssignee(),
                        listTask.get(i).getReviewer());
            }

        }
    }
}
