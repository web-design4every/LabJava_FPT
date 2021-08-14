
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author trinh
 */
public class HandyExpense {

    public void menu() {
        System.out.println("1. Add an expense");
        System.out.println("2. Display all expenses");
        System.out.println("3. Remove an expense");
        System.out.println("4. Exit");
    }

    public static void main(String[] args) {
        HandyExpense h = new HandyExpense();
        Option op = new Option();
        Validate v = new Validate();
        int choice;
        Scanner sc = new Scanner(System.in);
        ArrayList<Expense> list = new ArrayList<>();
        list.add(new Expense(1, "20-02-2020", 100, "buy house"));
        list.add(new Expense(2, "20-03-2020", 200, "buy iphone"));
        list.add(new Expense(3, "20-04-2020", 300, "buy laptop"));
        Expense e = new Expense(4, "19-05-1890", 400, "buy book");
        list.add(e);
        while (true) {
            h.menu();
            System.out.print("input choice: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    //call add method
                    op.add(list,v.getIDtoAdd(list),v.getDate(),v.getAmount(),v.getContent());
                    break;
                case 2:
                    //call display method
                    op.display(list);
                    break;
                case 3:
                    //call remove method
                    op.remove(list,v.getID());
                    break;
                case 4:
                    //exit
                    System.exit(0);
            }
        }
    }
}
