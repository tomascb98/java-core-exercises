package com.epam.rd.autotasks.sprintplanning.tickets;

public class Ticket {
    private int id;
    private String name;
    private int estimatedHours;
    private boolean isCompleted;

    public Ticket(int id, String name, int estimate) {
        this.id = id;
        this.name = name;
        this.estimatedHours = estimate;
        this.isCompleted = false;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public boolean isCompleted() {
        return this.isCompleted;
    }

    public void complete() {
        this.isCompleted = true;
    }

    public int getEstimate() {
        return this.estimatedHours;
    }
}
