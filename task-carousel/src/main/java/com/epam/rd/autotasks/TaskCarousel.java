package com.epam.rd.autotasks;

public class TaskCarousel {
    private int capacity;
    private Task[] tasks;
    private int positionToExecute;


    public TaskCarousel(int capacity) {
        this.capacity = capacity;
        this.tasks = new Task[capacity];
    }

    public boolean addTask(Task task) {
        if(isFull() || task==null || task.isFinished()) return false;
        for(int i = 0 ; i < capacity ; i++){
            if(tasks[i] == null){
                tasks[i] = task;
                break;
            }
        }
        return true;
    }

    public boolean execute() {
        boolean flagExecute = false;
        for(int i=0 ; i<capacity ; i++){
            if(positionToExecute == capacity) positionToExecute = 0;
            if(tasks[positionToExecute] == null){
                positionToExecute++;
            } else{
                tasks[positionToExecute].execute();
                if (tasks[positionToExecute].isFinished()) tasks[positionToExecute] = null;
                flagExecute = true;
                positionToExecute++;
                break;
            }
        }
        return flagExecute;
    }

    public boolean isFull() {
        int count = 0;
        for (int i = 0 ; i<capacity ; i++){
            if(tasks[i] != null) count++;
        }
        return count == capacity ;
    }

    public boolean isEmpty() {
        int count = 0;
        for (int i = 0 ; i<capacity ; i++){
            if(tasks[i] == null) count++;
        }
        return count == capacity ;
    }

}
