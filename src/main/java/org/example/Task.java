package org.example;

import java.util.ArrayList;
import java.util.Iterator;

/*
    Task Class - Represents a branch/non-terminal node. Keeps a collection of ProjectItems -
    Associated Tasks and Deliverables. Tasks also have an associated completion time attribute.
 */
public class Task implements ProjectItem {
    private String name;
    private String details;
    private ArrayList projectItems = new ArrayList();
    private Contact owner;
    private double timeRequired;

    public Task() { }
    public Task(String newName, String newDetails,
                Contact newOwner, double newTimeRequired) {
        name = newName;
        details = newDetails;
        owner = newOwner;
        timeRequired = newTimeRequired;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public Contact getOwner() {
        return owner;
    }

    public ArrayList getProjectItems() {
        return projectItems;
    }

    @Override
    public double getTimeRequired() {
        double totalTime = timeRequired;
        for (Object projectItem : projectItems) {
            ProjectItem item = (ProjectItem) projectItem;
            totalTime += item.getTimeRequired();
        }
        return totalTime;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setDetails(String newDetails) {
        details = newDetails;
    }

    public void setOwner(Contact newOwner) {
        owner = newOwner;
    }

    public void setTimeRequired(double newTimeRequired) {
        timeRequired = newTimeRequired;
    }

    public void addProjectItem(ProjectItem element) {
        if(!projectItems.contains(element)) {
            projectItems.add(element);
        }
    }

    public void removeProjectItem(ProjectItem element) {
        projectItems.remove(element);
    }
}
