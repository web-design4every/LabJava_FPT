
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author trinh
 */
public class Validate {

    Scanner sc = new Scanner(System.in);
    //method get amount for expense
    public double getAmount() {
        double amount = 0;
        while (true) {
            try {
                System.out.print("input amount: ");
                amount = Double.parseDouble(sc.nextLine());
                break;
            } catch (Exception e) {
                System.err.println("invalid amount, please input again");
            }
        }
        return amount;
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
    public int getIDtoAdd(ArrayList<Expense> list) {
        int lastIndex = list.size() - 1;
        int lastID = list.get(lastIndex).getId();
        int id = lastID + 1;
        return id;
    }
    public String getContent(){
        System.out.print("input content: ");
        return sc.nextLine();
    }
    //function get date for expense
    public String getDate(){
        //11-03-2020
        //->11-mar-2020
        SimpleDateFormat dfInput = new SimpleDateFormat("dd-MM-yyyy");
        //check exception date-> 30/2,31/2....
        dfInput.setLenient(false);
        SimpleDateFormat dfOutput = new SimpleDateFormat("dd-MMM-yyyy");
        Date d;
        while(true){
            try {
                System.out.print("input date: ");
                d = dfInput.parse(sc.nextLine());
                break;
            } catch (Exception e) {
                System.err.println("invalid date, please input again");
            }
        }
        return dfOutput.format(d);
    }
}
