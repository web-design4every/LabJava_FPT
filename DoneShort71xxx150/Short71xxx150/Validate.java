/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Short71xxx150;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author DAOTHAOVAN
 */
public class Validate {

    private static Scanner input = new Scanner(System.in);
    public static String PLAN_VALID = "[0-9]{1,2}\\.0|[0-9]{1,2}\\.5";

    public static int checkInputChoice(int min, int max) {
        while (true) {
            try {
                int choice = Integer.parseInt(input.nextLine());
                if (choice < min || choice > max) {
                    throw new NumberFormatException();
                }
                return choice;
            } catch (NumberFormatException ex) {
                System.out.println("Please enter number in range [" + min + "," + max + "]: ");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String checkInputTaskTypeID(ArrayList<Task> listTask,String requirementName) {
        while (true) {
            String result = null;
            int taskTypeID = checkInputChoice(1, 4);
            switch (taskTypeID) {
                case 1:
                    result = "Code";
                    break;
                case 2:
                    result = "Test";
                    break;
                case 3:
                    result = "Design";
                    break;
                case 4:
                    result = "Review";
                    break;

            }
            for (int i = 0; i < listTask.size(); i++) {
                if(requirementName.equalsIgnoreCase(listTask.get(i).getRequirementName()) && result.equalsIgnoreCase(listTask.get(i).getTaskTypeID())){
                    System.out.print("Exist! Enter different: ");
                }
                else{
                    return result;
                }
            }
            
        }
    }

    public static String checkInputString() {
        while (true) {
            String result = input.nextLine().trim();
            if (result.length() == 0) {
                System.out.print("Not Empty! Enter again: ");
            } else {
                return result;
            }
        }
    }

    public static String checkInputDate() {
        while (true) {
            String str = input.nextLine().trim();
            SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
            Date currentDate = new Date();
            f.setLenient(false);
            try {
                Date date = f.parse(str);
                if (currentDate.compareTo(date) > 0) {
                    System.out.print("Don't enter before today! Enter again: ");
                } else {
                    return str;
                }
            } catch (ParseException e) {
                System.out.println("Wrong format!(dd/MM/yyyy)!");
                System.out.print("Enter again: ");

            }
        }
    }

    public static String checkInputPlan(int key, double planCompare) {
        while (true) {

            String plan = checkInputString();
            if (key == 1) {
                if ((plan.matches(PLAN_VALID))
                        && (Double.parseDouble(plan) >= 8)
                        && (Double.parseDouble(plan) <= 17.5)) {
                    return plan;
                } else {
                    System.out.print("Enter again: ");
                }

            }
            if (key == 2) {
                if ((plan.matches(PLAN_VALID))
                        && (Double.parseDouble(plan) >= 8)
                        && (Double.parseDouble(plan) <= 17.5)
                        && Double.parseDouble(plan) > planCompare) {
                    return plan;
                } else {
                    System.out.print("Enter again: ");
                }

            }
        }
    }

    

}
