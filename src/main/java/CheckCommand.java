public class CheckCommand extends Command {
    final int checkInt;
    public CheckCommand(int checkInt) {
        this.checkInt = checkInt;
    }

    /**
     * Marks a task as done and prints a success message.
     * txt file and prints a success message.
     * @param ui a Ui instance to enable calling of Ui functions
     * @param storage a Storage instance to enable calling of Storage functions
     */
    @Override
    public String execute(Ui ui, Storage storage) {
        Task task = TaskList.toDoList.get(checkInt - 1);
        task.markAsDone();
        storage.save(TaskList.toDoList);
        /*ui.checkList(task.toString(), task.getTaskStatusIcon());
        ui.printNumberOfTasks(TaskList.toDoList.size());*/
        return ui.checkList(task.toString(), task.getTaskStatusIcon())
                + ui.printNumberOfTasks(TaskList.toDoList.size());
    }
}
