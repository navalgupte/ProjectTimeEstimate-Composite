package org.example;

import java.io.Serializable;

/*
    ProjectItem Interface - Describes functionality common to all items that are
    part of Project.
 */
public interface ProjectItem extends Serializable {
    public double getTimeRequired();
}
