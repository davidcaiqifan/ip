package duke;

import java.util.Scanner;

import duke.commands.Command;

public class Duke {
    /**
     * Runs the duke.Duke programme
     * @param args main args
     */
    public static void main(String[] args) {
        Ui ui = new Ui();
        Storage storage = new Storage("\\save.txt");
        ui.printWelcome();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String next = sc.nextLine();
            if (next.equals("bye")) {
                System.out.println("Bye! Woof!");
                break;
            }
            try {
                Command c = Parser.manage(next);
                c.execute(ui, storage);
            } catch (DukeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Gets a string output from Duke based on input given in order to output message for client.
     * @param input Input that is parsed to generate a output.
     */
    public String getResponse(String input) {
        Ui ui = new Ui();
        Storage storage = new Storage("\\save.txt");
        try {
            Command c = Parser.manage(input);
            return (c.execute(ui, storage));
        } catch (DukeException e) {
            return (e.getMessage());
        }
    }
}
