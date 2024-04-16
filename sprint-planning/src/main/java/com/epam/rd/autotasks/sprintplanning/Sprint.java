package com.epam.rd.autotasks.sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;

import java.util.Arrays;

public class Sprint {
    private int timeCapacity;
    private int ticketsLimit;
    private Ticket[] tickets;
    private int positionToAdd = 0;
    private int currentTime = 0;
    public Sprint(int capacity, int ticketsLimit) {
        this.timeCapacity = capacity;
        this.ticketsLimit = ticketsLimit;
        this.tickets = new Ticket[ticketsLimit];
    }

    public boolean addUserStory(UserStory userStory) {
        if(userStory == null) return false;
        int countDependencies = 0;
        UserStory[] dependencies = userStory.getDependencies();
        for(int i = 0 ; i < positionToAdd; i++){
            for (UserStory dependency : dependencies)
                if (tickets[i] == dependency) {
                    countDependencies++;
                }
        }
        if(positionToAdd <= ticketsLimit-1 && userStory.getEstimate() + currentTime <= timeCapacity && !userStory.isCompleted() && countDependencies == dependencies.length){
            tickets[positionToAdd] = userStory;
            positionToAdd++;
            currentTime += userStory.getEstimate();
            return true;
        } else{
            return false;
        }
    }

    public boolean addBug(Bug bugReport) {
        if (bugReport == null) return false;
        if(positionToAdd <= ticketsLimit-1 && bugReport.getEstimate() + currentTime <= timeCapacity && !bugReport.isCompleted()){
            tickets[positionToAdd] = bugReport;
            positionToAdd++;
            currentTime += bugReport.getEstimate();
            return true;
        } else{
            return false;
        }
    }

    public Ticket[] getTickets() {
        return Arrays.copyOf(tickets, positionToAdd);
    }

    public int getTotalEstimate() {
        return this.currentTime;
    }
}
