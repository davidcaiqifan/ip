import java.util.List;

/**
 * Encapsulates the user interface.
 */
public class Ui {

    /**
     * Prints the default welcome message.
     */
    public void printWelcome() {
        System.out.println("--------------------------------------");
        System.out.println("Hello from doge");
        System.out.println("______________________$$$$$$$$\n"
                + "_______________$$$$$$$________$$$$$$$$$\n"
                + "_____________$$________________________$$$$\n"
                + "____________$$_____________________________$$\n"
                + "___________$__________________________________$$\n"
                + "___________$$___________________________________$$\n"
                + "__________ $$__$$______________________$$__________$$\n"
                + "________$$__$$___$$$$_________$$$$____$$__________$$$$\n"
                + "______$$___$$__$$$$__$$_____$$$$__$$_$$_____________$$$\n"
                + "______$$___$$____$$$$_________$$$$___$$_______________$$\n"
                + "______$$___$$________________________$$_______________$$\n"
                + "______$$____$$_______________________$$_____________$$\n"
                + "________$$__$$____$$$$$$_____________$$___________$$$\n"
                + "________$$__$$__$$______$$___________$$_________$$\n"
                + "________$$__$$__$$______$$___________$$_______$$\n"
                + "__________$$$$____$$$$$$_____________$$$$____$$$$\n"
                + "__________$$$$_____________________$$__$$____$$$\n"
                + "___________$$_$$$$$$$$$$$$_____$$$$______$$$$_$$\n"
                + "_____________$$___$$______$$$$$_______________$$\n"
                + "_____________$$_____$$$$$$$____________________$$\n"
                + "_____________$$________________________________$$\n"
                + "____________$$_________________________________$$\n"
                + "____________$$_________________________________$$\n"
                + "____________$$___________________________________$\n"
                + "____________$$___________________________________$$\n"
                + "__________$$_________________________$$___________$\n"
                + "__________$$__________$$___________$$_____________$$\n"
                + "________$$__$$________$$_________$$_______________$$\n"
                + "______$$____$$__________$$_______$$_______________$$\n"
                + "______$$____$$____________$$___$$_________________$$\n"
                + "____$$______$$_____________$$_$$_______$$_________$$\n"
                + "____$$______$$________$$____$$$________$$_________$$\n"
                + "____$$______$$________$$____$$$_______$$__________$$\n"
                + "____$$______$$________$$_______________$$__________$$\n"
                + "____$$______$$________$$_______________$$____________$\n"
                + "_$$$$_______$$________$$_______________$$____________$$\n"
                + "$___$$______$$________$$$$___________$$$$____________$$\n"
                + "$___$$______$$________$$__$$_______$$__$$____________$$\n"
                + "_$$$$$______$$________$$____$$___$$_____$$___________$$\n"
                + "____$$______$$________$$______$$_______$$___________$$\n"
                + "____$$______$$________$$_____$$________$$___________$$\n"
                + "__$$________$$________$$$$$$$$___$$$$$$__$$_________$$\n"
                + "__$$________$$________$$______$$$______$$$$_________$$\n"
                + "$$________$$__________$$_________$$$$$$__$$__________$\n"
                + "$$______$$__________$$$$$$$$$$$$$$$______$$__________$\n"
                + "$$_$$_$$$__________$$_____________$$$$$$$__$$_________$\n"
                + "_$$$$$$$___________$$______________________$$________$$\n"
                + "_____$$__$$__$$__$$_$______________________$$__________$$\n"
                + "______$$$$__$___$__$$______________________$$____________$\n"
                + "_______$$___$___$__$________________________$$_$__$$__$$__$\n"
                + "_________$$$$$$$$$$__________________________$$_$_$$$$$$$$\n");
        System.out.println("What can this good boi do for you?");
        System.out.println("--------------------------------------");
    }

    /**
     * Prints a given string but adds "Added : " in front of the message.
     * @param msg given string
     */
    public void taskPrint(String msg) {
        System.out.println("Added : " + msg);
    }


    /** Prints out a given ArrayList of tasks in a nice format, with the
     * given displayMessage on top.
     * @param toDoList given todolist
     * @param displayMessage message to be displayed
     */
    public void displayList(List<Task> toDoList, String displayMessage) {
        System.out.println(displayMessage);
        int i = 1;
        for (Task s : toDoList) {
            System.out.println(i + ". " + " [" + s.getType() + "] "
                    + s.toString() + " [" + s.getTaskStatusIcon() + "]");
            i += 1;
        }
    }

    /**
     * Prints the completion of a task
     * @param task task description
     * @param taskStatus icon representing completion of task
     */
    public void checkList(String task, String taskStatus) {
        System.out.println("--------------------------------------");
        System.out.println("Such wow! I have completed the following task!");
        System.out.println(task + " [" + taskStatus + "]");
        System.out.println("--------------------------------------");
    }

    /**
     * Prints formatted message when task is removed
     * @param taskId given task id
     */
    public void removePrint(int taskId) {
        Task tr = TaskList.toDoList.get(taskId - 1);
        System.out.println("Task successfully removed!");
        System.out.println("-> " + tr.toString());
    }

    /**
     * Formats and prints input String
     * @param print input string
     */
    public void printFormat(String print) {
        System.out.println("--------------------------------------");
        //System.out.println("Added to task list : " + print);
        System.out.println("Added to list : " + print);
        System.out.println("--------------------------------------");
    }

    /**
     * Prints number of tasks left
     * @param listSize number of tasks left
     */
    public void printNumberOfTasks(int listSize) {
        System.out.println("You have a total of " + listSize + " tasks");
        System.out.println("--------------------------------------");
    }
}
