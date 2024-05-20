package org.example;

import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class RunPattern {
    public static void main(String[] args) {
        System.out.println("Example showing use of Composite Pattern");
        System.out.println("---- ---- ---- ---- ----");
        if(!(new File("data.ser").exists())) {
            DataCreator.serialize("data.ser");
        }

        Project project = (Project) (DataRetriever.deserializeData("data.ser"));
        System.out.println("Calculating the total time estimate for the project - " + project.getName());
        System.out.println("\t" + project.getDescription());
        System.out.println("\tTime required: " + project.getTimeRequired());
        System.out.println("---- ---- ---- ---- ----");
    }
}