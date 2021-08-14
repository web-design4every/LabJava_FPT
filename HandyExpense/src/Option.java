
import java.util.ArrayList;
import java.util.Scanner;

public class Option implements IOption{

    Scanner sc = new Scanner(System.in);
    Validate v = new Validate();

    @Override
    public void add(ArrayList<Expense> list,int id, String date, double amount,String content) {
        Expense e = new Expense();
        e.setId(id);
        e.setDate(date);
        e.setAmount(amount);
        e.setContent(content);
        list.add(e);
    }

    @Override
    public void display(ArrayList<Expense> list) {
        System.out.println("ID\tDate\t\tAmount of money\tContent");
        for (Expense o : list) {
            System.out.println(o);
        }
    }

    @Override
    public void remove(ArrayList<Expense> list, int id) {
        boolean check = true;
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if(id==list.get(i).getId()){
                list.remove(i);
                check = false;
                index = i;
                System.out.println("Delete an expense successful");
                break;
            }
        }
        if(check){
            System.out.println("Delete an expense fail");
        }
        if(!check){
            for (int i = index; i < list.size(); i++) {
                list.get(i).setId(i+1);
            }
        }
    }
}
