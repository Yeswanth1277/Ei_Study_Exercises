// Command Interface
interface Command {
    void execute();
}

// Receiver - The actual light that performs the action
class Light {
    public void turnOn() {
        System.out.println("The light is on.");
    }
    
    public void turnOff() {
        System.out.println("The light is off.");
    }
}

// Concrete Command for turning the light on
class TurnOnLightCommand implements Command {
    private Light light;

    public TurnOnLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

// Concrete Command for turning the light off
class TurnOffLightCommand implements Command {
    private Light light;

    public TurnOffLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

// Invoker - The remote control
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// Main Application - CommandPatternDemo
public class CommandPatternDemo {
    public static void main(String[] args) {
        // Receiver
        Light livingRoomLight = new Light();
        
        // Concrete Commands
        Command turnOnCommand = new TurnOnLightCommand(livingRoomLight);
        Command turnOffCommand = new TurnOffLightCommand(livingRoomLight);
        
        // Invoker (Remote Control)
        RemoteControl remote = new RemoteControl();
        
        // Turn the light on
        remote.setCommand(turnOnCommand);
        remote.pressButton(); // Output: The light is on.
        
        // Turn the light off
        remote.setCommand(turnOffCommand);
        remote.pressButton(); // Output: The light is off.
    }
}
