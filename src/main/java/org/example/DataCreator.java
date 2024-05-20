package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
    DataCreator Class - Creates sample Project data and serializes it to a file.
 */
public class DataCreator {
    private static final String DEFAULT_FILE = "data.ser";

    public static void main(String[] args) {
        String fileName;

        if(args.length == 1) {
            fileName = args[0];
        } else {
            fileName = DEFAULT_FILE;
        }
        serialize(fileName);
    }

    public static void serialize(String fileName) {
        try {
            serializeToFile(createData(), fileName);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    private static Serializable createData() {
        Contact contact1 = new ContactImpl("Chris", "Arnold",
                "Chief Technology Officer / Chief Architect", "Upstream Solutions");
        Contact contact2 = new ContactImpl("Mike", "Deere",
                "Marketing Director", "Upstream Solutions");
        Contact contact3 = new ContactImpl("Cliff", "Osborne",
                "Chief Finance Officer", "Upstream Solutions");

        Project project = new Project("Complete PIM Solution", "Build a fully customizable Personal Information Manager.");
        Deliverable deliverable1 = new Deliverable("PIM Solution", "", contact1);
        Task task1 = new Task("Research and Develop", "Build a working prototype for PIM",
                contact1, 40);
        Task task2 = new Task("Explore Markets", "Analyze product-market fit - Identify potential markets.",
                contact2, 20);
        Task task3 = new Task("Get Funding - Manage Expenses", "Locate funding opportunities - Find resources to develop product.",
                contact3, 60);

        project.addProjectItem(deliverable1);
        project.addProjectItem(task1);
        project.addProjectItem(task2);
        project.addProjectItem(task3);

        Deliverable deliverable11 = new Deliverable("Provenance Solution", "", contact1);
        Task task11 = new Task("DLT Solution", "Find suitable experience and build a working DLT model for Provenance Solution.",
                contact1, 30);
        Task task12 = new Task("Market Readiness", "Determine market openness and acceptance.",
                contact2, 50);
        Task task13 = new Task("Resource Investment", "Determine investments and ROI.",
                contact3, 60);

        task1.addProjectItem(task11);
        task1.addProjectItem(task12);
        task1.addProjectItem(task13);
        task1.addProjectItem(deliverable11);

        return project;
    }

    private static void serializeToFile(Serializable content, String filename) throws IOException {
        ObjectOutputStream serOut = new ObjectOutputStream(new FileOutputStream(filename));
        serOut.writeObject(content);
        serOut.close();
    }
}
