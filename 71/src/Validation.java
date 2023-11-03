
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author GIA KHANH
 */
public class Validation {

    Scanner sc = new Scanner(System.in);

    public int getInt(String msg, int min, int max) {
        while (true) {
            try {
                System.out.print(msg);
                int n = Integer.parseInt(sc.nextLine());
                if (n < min || n > max) {
                    System.err.println("Invalid! Please input again");
                    continue;
                }
                return n;
            } catch (NumberFormatException e) {
                System.err.println("Invalid! Please input again");
            }
        }
    }

    public String getString(String msg, String regex) {
        String input;
        while (true) {
            System.out.print(msg);
            try {
                input = sc.nextLine().trim();
                if (!input.matches(regex)) {
                    throw new Exception();
                }
                return input;
            } catch (Exception e) {
                System.err.println("Invalid, please try again");
            }
        }
    }

    public String checkInputDate(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                String result = sc.nextLine().trim();
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                Date date = format.parse(result);
               if (result.equalsIgnoreCase(format.format(date))) {
                    return result;
                }
                System.err.println("Invalid date! Please input again");
            } catch (ParseException e) {
                System.err.println("Invalid date! Please input again");
            }
        }
    }

    public String planFromTo(String msg) {
        while (true) {
            System.out.print(msg);
            String plan = sc.nextLine().trim();
            if (plan.matches("^[0-9]{1,2}\\.0|[0-9]{1,2}\\.5||[0-9]{1,2}$") && Double.parseDouble(plan) >= 8.0
                    && Double.parseDouble(plan) <= 17.5) {
                return plan;
            }
            System.err.println("Invalid time");
        }
    }

    public boolean checkPlan(String planFrom, String planTo) {
        if (Double.parseDouble(planFrom) < Double.parseDouble(planTo)) {
            return true;
        }
        return false;
    }
    
        public String taskTypeId() {
        String result = null;
        int n = getInt("Input task type id: ", 1, 4);
        switch (n) {
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
        return result;
    }
    
}
