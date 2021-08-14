
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author trinh
 */
public class Validate {

    Scanner sc = new Scanner(System.in);

    public void menu() {
        System.out.println("1. Add task");
        System.out.println("2. Delete task");
        System.out.println("3. Display task");
        System.out.println("3. Exit");
    }

    public int getChoice() {
        int choice = 0;
        while (true) {
            try {
                System.out.print("input your choice: ");
                choice = Integer.parseInt(sc.nextLine());
                if (choice >= 1 && choice <= 4) {
                    break;
                }
            } catch (Exception e) {
                System.err.println("invalid choice, please input again");
            }
        }
        return choice;
    }

    public int getIdToAdd(ArrayList<Task> list) {
        int lastIndex = list.size() - 1;
        int lastId = list.get(lastIndex).getId();
        int newId = lastId + 1;
        return newId;
    }

    public String getName() {
        System.out.print("input name: ");
        String name = sc.nextLine();
        return name;
    }

    public int getTypeID() {
        //1-4
        int id = 0;
        while (true) {
            try {
                System.out.print("input type id: ");
                id = Integer.parseInt(sc.nextLine());
                if (id >= 1 && id <= 4) {
                    break;
                }
            } catch (Exception e) {
                System.err.println("invalid choice, please input again");
            }
        }
        return id;
    }

    public String getDate() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        df.setLenient(false);
        Date date;
        while (true) {
            try {
                System.out.print("input date: ");
                date = df.parse(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("invalid date,please input again: ");
            }
        }
        return df.format(date);
    }

    public double getFrom() {
        double from = 0;
        while (true) {
            try {
                System.out.print("input from: ");
                from = Double.parseDouble(sc.nextLine());
                if (from >= 8 && from <= 15.5) {
                    if (from % 0.5 == 0) {
                        break;
                    }
                }
            } catch (Exception e) {
                System.err.println("invalid amount, please input again");
            }
        }
        return from;
    }

    public double getTo(double from) {
        double to = 0;
        while (true) {
            try {
                System.out.print("input to: ");
                to = Double.parseDouble(sc.nextLine());
                if (to >= 8 && to <= 15.5) {
                    if (to % 0.5 == 0) {
                        if(to>from){
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                System.err.println("invalid amount, please input again");
            }
        }
        return to;
    }
    public String getAssign() {
        System.out.print("input assign: ");
        String assign = sc.nextLine();
        return assign;
    }
    public String getReviewer() {
        System.out.print("input reviewer: ");
        String review = sc.nextLine();
        return review;
    }
     public int getID() {
        int id = 0;
        while (true) {
            try {
                System.out.print("input id: ");
                id = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.err.println("invalid amount, please input again");
            }
        }
        return id;
    }
}
