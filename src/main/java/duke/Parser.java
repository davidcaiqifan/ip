package duke;

import java.time.LocalDate;
import java.util.ArrayList;

import duke.commands.AddCommand;
import duke.commands.CheckCommand;
import duke.commands.Command;
import duke.commands.ErrorCommand;
import duke.commands.PrintlistCommand;
import duke.commands.RemoveCommand;
import duke.commands.SearchCommand;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;



/**
 * Object to parse a line of input given by user
 */
public class Parser {

    /**
     * Returns a duke.commands.Command based on user input
     * @param input user input
     * @return command based on user input
     * @throws DukeException exception that occurs when parser does not
     * recognise user input
     */
    public static Command manage(String input) throws DukeException {
        if (input.equals("list")) {
            return new PrintlistCommand();
        } else if (input.contains("check")) {
            return processCheck(input);
        } else if (input.contains("find")) {
            return processSearch(input);
        } else if (input.contains("remove")) {
            return processRemoval(input);
        } else if (input.contains("todo")) {
            return processTodo(input);
        } else if (input.contains("deadline")) {
            return processDeadline(input.substring(9));
        } else if (input.contains("event")) {
            return processEvent(input.substring(6));
        } else {
            throw new DukeException("Oops! There is no such keyword!");
        }
    }

    private static Command processRemoval(String input) {
        int removeInt;
        try {
            String intAtBack = input.substring(7);
            removeInt = Integer.parseInt(intAtBack);
            return new RemoveCommand(removeInt);
        } catch (Exception e) {
            return new ErrorCommand(e.getMessage());
        }
    }

    private static Command processSearch(String input) {
        String keyword = input.substring(5);
        String[] searchArray = checkCommas(keyword).toArray(new String [0]);
        return new SearchCommand(searchArray);
    }

    private static Command processCheck(String input) {
        int checkInt;
        try {
            String intAtBack = input.substring(6);
            checkInt = Integer.parseInt(intAtBack);
            return new CheckCommand(checkInt);
        } catch (Exception e) {
            return new ErrorCommand(e.getMessage());
        }
    }

    private static ArrayList<String> checkCommas(String input) {
        ArrayList<String> returnArray = new ArrayList<>();
        if (input.contains(",")) {
            int commaIndex = input.indexOf(",");
            returnArray.addAll(checkCommas(input.substring(0, commaIndex)));
            returnArray.addAll(checkCommas(input.substring(commaIndex + 1)));
        } else {
            returnArray.add(input);
        }
        return returnArray;
    }

    private static Command processTodo(String input) throws DukeException {
        if (checkEmpty(input, "todo")) {
            throw new DukeException("Much error! You have to describe your mission!");
        }
        ArrayList<String> todos = checkCommas(input.substring(5));
        ArrayList<Task> todoTasks = new ArrayList<>();
        for (String s : todos) {
            todoTasks.add(new ToDo(s));
        }
        return new AddCommand(todoTasks.toArray(new Task[0]));
    }

    private static Command processEvent(String input) throws DukeException {
        if (checkEmpty(input, "event")) {
            throw new DukeException("Much error! You have to describe your event!");
        }
        ArrayList<String> events = checkCommas(input);
        ArrayList<Task> eventTasks = new ArrayList<>();
        for (String s : events) {
            if (checkPlan(s)) {
                throw new DukeException("Oh no, you do not have a planned timing for your event!");
            } else if (input.contains("/")) {
                eventTasks.add(new Event(parseDate(s, "on")));
            } else {
                eventTasks.add(new Event(s));
            }
        }
        return new AddCommand(eventTasks.toArray(new Task[0]));
    }

    private static Command processDeadline(String input) throws DukeException {
        if (checkEmpty(input, "deadline")) {
            throw new DukeException("Much error! You have to describe your deadline!");
        }
        ArrayList<String> events = checkCommas(input);
        ArrayList<Task> eventTasks = new ArrayList<>();
        for (String s : events) {
            if (checkPlan(s)) {
                throw new DukeException("Oh no, you do not have a planned timing for your deadline!");
            } else if (input.contains("/")) {
                eventTasks.add(new Deadline(parseDate(s, "by")));
            } else {
                eventTasks.add(new Deadline(s));
            }
        }
        return new AddCommand(eventTasks.toArray(new Task[0]));
    }

    private static String parseDate(String input, String keyword) {
        int notePos = input.indexOf("/") + 1;
        String note = input.substring(notePos);
        String echo = input.substring(0, notePos - 1) + " ------> " + note;
        if (input.contains(keyword)) {
            int byPos = input.indexOf(keyword) + 3;
            String time = input.substring(byPos);
            try {
                String parsedTime = formatDate(time);
                return input.substring(0, notePos - 1)
                        + keyword + " " + parsedTime;
            } catch (Exception e) {
                return echo;
            }
        } else {
            return echo;
        }
    }

    private static Boolean checkEmpty(String input, String keyWord) {
        int keywordLength = keyWord.length();
        String remainingDescription = input.substring(keywordLength);
        if (remainingDescription.length() == 0) {
            return true;
        } else if (remainingDescription.length() > 1 && remainingDescription.charAt(1) == 32) {
            return true;
        } else {
            return remainingDescription.length() <= 1;
        }
    }

    //returns true if there is a description
    private static Boolean checkPlan(String input) {
        if (input.contains("/")) {
            String remainingDescription = input.substring(input.indexOf("/") + 1);
            return remainingDescription.length() == 0;
        }
        return true;
    }

    private static String formatDate(String date) {
        LocalDate parseDate = LocalDate.parse(date);
        return parseDate.getDayOfWeek() + " " + parseDate.getDayOfMonth() + " "
                + parseDate.getMonth() + " " + parseDate.getYear();
    }

}
