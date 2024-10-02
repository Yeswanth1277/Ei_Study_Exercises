import java.io.*;
import java.util.*;

interface Observer {
    void update(String message);
}

class User implements Observer {
    private String name;
    public User(String name) { this.name = name; }
    public void update(String message) {
        System.out.println(name + " received update: " + message);
    }
}

class TaskManager {
    private List<Observer> observers = new ArrayList<>();
    
    public void addObserver(Observer o) {
        observers.add(o);
    }
    
    public void notifyObservers(String message) {
        for (Observer o : observers) {
            o.update(message);
        }
    }
    
    public void addTask(String task) {
        // logic to add task
        notifyObservers("New task added: " + task);
    }
}

public class TaskManagerTest {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        
        // Creating observers
        User user1 = new User("Alice");
        User user2 = new User("Bob");
        
        // Adding observers to the TaskManager
        taskManager.addObserver(user1);
        taskManager.addObserver(user2);
        
        // Adding a task to trigger notification
        taskManager.addTask("Complete the report");
    }
}
