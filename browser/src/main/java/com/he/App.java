package com.he;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        String command = "goto";
        Page currentPage = new Page("Some com.he.Page");
        List<Page> pages = new ArrayList<Page>();
        pages.add(currentPage);
        Browser browser = new Browser(currentPage);
        History history = new History(browser);
        CommandDispatcher commandDispatcher = new CommandDispatcher(history, pages, browser);
        commandDispatcher.dispatch(command);
    }
}
