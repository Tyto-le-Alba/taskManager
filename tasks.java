import java.util.Scanner;
import java.util.ArrayList;

import java.io.*;

public class tasks extends gui {
    ArrayList<String> task_list;
    // String[] task_list;
    String[] temp_list;
    String file;
    Scanner input;

    public tasks() {
        this.task_list = new ArrayList<String>();
        this.file = "user_tasks.txt";
        this.input = new Scanner(System.in);
    }

    public static void main(String[] args) {
        // need to read from a list, to populte the current dictionary.
        // read_file("user_tasks.csv");
        tasks my_tasks = new tasks();
        my_tasks.read_file(my_tasks.file);
        while (true) {
            my_tasks.menu();
        }

    };

    public void menu() {

        System.out.println("\nWhat would you like to do?");
        System.out.println("1: Add new task");
        System.out.println("2: View Tasks");
        System.out.println("3: Mark task as done");
        System.out.println("4: Exit\n");

        ll: try {
            int ans = Integer.parseInt(this.input.nextLine());
            if (ans > 4) {
                System.out.println("Please enter a number between 1 and 4");
                break ll;
            }
            switch (ans) {
                case 1:
                    add_task();
                    break;
                case 2:
                    list_tasks();
                    break;
                case 3:
                    mark_done();
                    break;
                case 4:
                    write_out();
                    System.exit(0);
                    break;
                default:
                    break;

            }

        } catch (Exception e) {
            System.out.println("Please enter a valid number.");
        }

    }

    public void read_file(String file) {
        try {

            FileReader filereader = new FileReader(file);
            BufferedReader reader = new BufferedReader(filereader);

            String value;
            while ((value = reader.readLine()) != null) {
                this.task_list.add(value);
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void add_task() {
        System.out.println("Enter Task: ");
        this.task_list.add(this.input.nextLine());
    }

    public void list_tasks() {
        int n = 0;
        System.out.println("\n********** TASK LIST **********");
        for (String val : this.task_list) {
            System.out.println(n + " : " + val);
            n++;
        }
        System.out.println("\n");
    }

    public void mark_done() {

        while (true) {
            System.out.println("Which would you like to mark done? \n");
            this.list_tasks();

            ls: try {
                int ans = Integer.parseInt(this.input.nextLine());
                if (ans > this.task_list.size()) {
                    System.out.println("Please enter a number between 1 and " + this.task_list.size());
                    break ls;
                }

                this.task_list.remove(ans);
                break;

            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
            }
        }

    }

    public void write_out() {
        try {
            FileWriter my_file = new FileWriter(this.file);
            BufferedWriter writer = new BufferedWriter(my_file);

            for (String val : this.task_list) {
                writer.write(val + "\n");
            }
            writer.close();
        } catch (Exception e) {
            System.err.println(e);
        }

    }

}
