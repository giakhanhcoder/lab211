/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GIA KHANH
 */
public class Manager {

    BO_Task boTask = new BO_Task();
    Validation v = new Validation();

    public void addTask() {
        System.out.println("------------Add Task---------------");
        int idNumber;
        if(boTask.isEmpty()){
            idNumber = 1;
        }else{
            idNumber = boTask.getLastID() + 1;
        }
        String requirementName = v.getString("Input requirement name: ", "[A-Za-z\\s]+");
        String taskTypeId = v.taskTypeId();
        String date = v.checkInputDate("Input date: ");
        String planFrom;
        String planTo;
        while (true) {
            planFrom = v.planFromTo("Input plan from: ");
            planTo = v.planFromTo("Input plan to: ");
            if (v.checkPlan(planFrom, planTo)) {
                break;
            }
            System.err.println("Plan from must be earlier than plan to");
        }

        String assignee = v.getString("Input assignee: ", "[A-Za-z\\s]+");
        String reviewer;
        while (true) {
            reviewer = v.getString("Input reviewer: ", "[A-Za-z\\s]+");
            if (!assignee.equalsIgnoreCase(reviewer)) {
                break;
            }
            System.err.println("Reviewer must be different from the assignee");
        }

        Task task = new Task(idNumber, requirementName, taskTypeId, date, planFrom, planTo, assignee, reviewer);

        if (boTask.checkDuplicateTask(task)) {
            System.out.println("This task already exist");
            return;
        }
        boTask.addTask(task);
        System.out.println("ADD SUCCESFULLY");
    }

    public void deleteTask() {
         System.out.println("----------------Delete Task---------------");
         int idFind = v.getInt("Input Id: ", 1, Integer.MAX_VALUE);
         Task taskDelete = boTask.getTaskById(idFind);
         if(taskDelete == null){
             System.out.println("Not found");
             return;
         }
         boTask.removeTask(taskDelete);
         System.out.println("DELETE SUCCESFULLY");
    }

    public void showTask() {
        if (boTask.isEmpty()) {
            System.out.println("Nothing to show");
            return;
        }
        System.out.println("----------------------------------------- Task ---------------------------------------");
        System.out.printf("%-5s%-20s%-15s%-20s%-15s%-10s%-10s\n", "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        for (Task task : boTask.showTask()) {
            double time = Double.parseDouble(task.getPlanTo()) - Double.parseDouble(task.getPlanFrom());
            System.out.printf("%-5s%-20s%-15s%-20s%-15s%-10s%-10s\n", task.getId(), task.getRequirementName(),
                    task.getTaskTypeId(), task.getDate(), time, task.getAssignee(), task.getReviewer());
        }
    }
}
