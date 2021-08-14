
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author trinh
 */
public class Option {

    public void getDataTasks(ArrayList<Task> list) {
        for (Task o : list) {
            System.out.println(o);
        }
    }
    public void addTask(ArrayList<Task> list, int id, String name,int typeid, String date,
            double from, double to,String assing, String review){
        Task t = new Task(id, name, typeid, date, from, to, assing, review);
        list.add(t);
    }
    public void delete(ArrayList<Task> list, int id){
        boolean check = true;
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if(id==list.get(i).getId()){
                list.remove(i);
                check = false;
                index = i;
                System.out.println("Delete an task successful");
                break;
            }
        }
        if(check){
            System.out.println("Delete an task fail");
        }
    }
}
