
import java.util.ArrayList;

/**
 *
 * @author trinh
 */
public interface IOption {
    public void add(ArrayList<Expense> list,int id, String date, double amount,String content);
    public void display(ArrayList<Expense> list);
    public void remove(ArrayList<Expense> list, int id);
}
