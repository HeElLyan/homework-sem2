package com.he.springios.interpreter;

import com.he.springios.model.NameEntry;
import com.he.springios.storage.NameEntryRepository;

import java.util.ArrayList;
import java.util.List;

public class InterpreterCore {

    @CmdMapping("add")
    private void goTo(Environment env, String[] args) {
        CommandUtil.requireSize(args, 1);
        String name = args[0];
        NameEntryRepository nameStorage = env.getAttribute("nameStorage", NameEntryRepository.class);

        NameEntry nameEntry = NameEntry.builder()
                .name(name)
                .build();

        nameStorage.save(nameEntry);
    }

    @CmdMapping("out")
    private void out(Environment env, String[] args) {
        CommandUtil.requireSize(args, 0);
        NameEntryRepository nameStorage = env.getAttribute("nameStorage", NameEntryRepository.class);
        List<NameEntry> nameEntries = new ArrayList<>();
        nameStorage.findAll().forEach(nameEntries::add);
        System.out.println(nameEntries);
    }

}
