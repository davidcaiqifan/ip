import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        /*String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";*/

        System.out.println("--------------------------------------");
        System.out.println("Hello from doge");
        System.out.println("What can this good boi do for you?");
        System.out.println("--------------------------------------");

        TaskManager taskManager = new TaskManager();
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()) {
            String next = sc.nextLine();

            if(next.equals("bye") ) {
                System.out.println("Woof!");
                break;
            }

            try {
                taskManager.manage(next);
            }
            catch(DukeException e) {
                System.out.println(e);
            }

        }

    }
}
