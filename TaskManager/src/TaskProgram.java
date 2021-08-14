
import java.util.ArrayList;


/**
 *
 * @author trinh
 */
public class TaskProgram {
    public static void main(String[] args) {
        ArrayList<Task> list = new ArrayList<>();
        list.add(new Task(1, "Dev program", 1, "20-02-2020",
                8.0, 10.0, "Dev", "Lead"));
        list.add(new Task(2, "Test program", 2, "21-02-2020",
                8.0, 10.0, "Test", "Lead"));
        list.add(new Task(3, "Dev program", 3, "22-02-2020",
                8.0, 10.0, "Dev 1", "Lead"));
        list.add(new Task(4, "Dev program", 4, "23-02-2020",
                8.0, 10.0, "Dev 2", "Lead"));
        Validate v = new Validate();
        Option o = new Option();
        while(true){
            v.menu();
            int choice = v.getChoice();
            switch(choice){
                case 1:
                    int id = v.getIdToAdd(list);
                    String name = v.getName();
                    int typeID = v.getTypeID();
                    String date = v.getDate();
                    double from = v.getFrom();
                    double to = v.getTo(from);
                    String assign = v.getAssign();
                    String review = v.getReviewer();
                    o.addTask(list, id, name, typeID, date, from, to, assign, review);
                    break;
                case 2:
                    int idDelete = v.getID();
                    o.delete(list, idDelete);
                    break;
                case 3:
                    o.getDataTasks(list);
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
        
    }
}
