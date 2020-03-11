package com.he;

import com.he.proxy.TaskProxyFactory;
import com.he.proxy.permission.UserType;
import com.he.tasks.Task;
import com.he.tasks.TaskBuilder;

import java.io.PrintWriter;
import java.util.EnumMap;
import java.util.List;

public class AppProxy {

    public static void main(String[] args) {
        Task task;
        TaskProxyFactory factory;
        EnumMap<UserType, List<String>> permissionMap;

        permissionMap = new EnumMap<>(UserType.class);
        permissionMap.put(UserType.USER, List.of("setText"));

        task = new TaskBuilder().error("").build();
        factory = new TaskProxyFactory();
        task = factory.newLoggerProxyInstance(task, new PrintWriter(System.out));

        task.setText("setSomeTest");
    }

}
