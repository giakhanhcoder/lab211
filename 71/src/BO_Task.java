
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author GIA KHANH
 */
public class BO_Task {

    private ArrayList<Task> t = new ArrayList<>();

    public void addTask(Task t1) {
        t.add(t1);
    }

    public void removeTask(Task theTask) {
        t.remove(theTask);
    }

    public Task getTaskById(int id) {
        for (Task task : t) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public boolean checkDuplicateTask(Task task) {
        for (Task task1 : t) {
            double planTo1 = Double.parseDouble(task1.getPlanTo());
            double planFrom1 = Double.parseDouble(task1.getPlanFrom());
            double planTo = Double.parseDouble(task.getPlanTo());
            double planFrom = Double.parseDouble(task.getPlanFrom());
            if (task1.getRequirementName().equalsIgnoreCase(task.getRequirementName())
                    && planTo1 == planTo && planFrom1 == planFrom
                    && task1.getAssignee().equalsIgnoreCase(task.getAssignee())
                    && task1.getDate().equalsIgnoreCase(task.getDate())
                    && task1.getReviewer().equalsIgnoreCase(task.getReviewer())
                    && task1.getTaskTypeId().equalsIgnoreCase(task.getTaskTypeId())) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return t.isEmpty();
    }

    public int getLastID() {
        return t.get(t.size() - 1).getId();
    }

    public ArrayList<Task> showTask() {
        return t;
    }

}
