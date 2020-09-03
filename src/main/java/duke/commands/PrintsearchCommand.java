package duke.commands;

import duke.Storage;
import duke.Ui;
import duke.task.TaskList;

public class PrintsearchCommand extends Command {
    final String[] keyword;

    public PrintsearchCommand(String[] keyword) {
        this.keyword = keyword;
    }

    /**Calls the displayList function in the ui class which prints out a provided
     * list of duke.task.
     */
    @Override
    public String execute(Ui ui, Storage storage) {
        return ui.displayList(TaskList.searchList(this.keyword),
                "Doge found the following tasks you asked for!");
    }
}
