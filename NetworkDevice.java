import java.util.ArrayList;
import java.util.List;

public abstract class NetworkDevice {
    private String id;
    private String type; // This can be used for logging or display purposes

    public NetworkDevice(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public abstract void displayInfo(); // Abstract method for displaying device info

    public abstract void performDiagnostics(); // Abstract method for diagnostics

    // Derived classes can be defined here

    public static class Router extends NetworkDevice {
        private int routingTableSize;

        public Router(String id, int routingTableSize) {
            super(id, "Router");
            this.routingTableSize = routingTableSize;
        }

        @Override
        public void displayInfo() {
            System.out.println("Device ID: " + getId() + ", Type: " + getType() + ", Routing Table Size: " + routingTableSize);
        }

        @Override
        public void performDiagnostics() {
            System.out.println("Performing diagnostics on the router.");
        }
    }

    public static class Switch extends NetworkDevice {
        private int numberOfPorts;

        public Switch(String id, int numberOfPorts) {
            super(id, "Switch");
            this.numberOfPorts = numberOfPorts;
        }

        @Override
        public void displayInfo() {
            System.out.println("Device ID: " + getId() + ", Type: " + getType() + ", Number of Ports: " + numberOfPorts);
        }

        @Override
        public void performDiagnostics() {
            System.out.println("Performing diagnostics on the switch.");
        }
    }

    public static class Firewall extends NetworkDevice {
        public Firewall(String id) {
            super(id, "Firewall");
        }

        @Override
        public void displayInfo() {
            System.out.println("Device ID: " + getId() + ", Type: " + getType());
        }

        @Override
        public void performDiagnostics() {
            System.out.println("Performing diagnostics on the firewall.");
        }
    }

    public static class PC extends NetworkDevice {
        private DeviceConfiguration configuration;

        public PC(String id, DeviceConfiguration configuration) {
            super(id, "PC");
            this.configuration = configuration;
        }

        @Override
        public void displayInfo() {
            System.out.println("Device ID: " + getId() + ", Type: " + getType() + ", Configuration: " + configuration);
        }

        @Override
        public void performDiagnostics() {
            System.out.println("Performing diagnostics on the PC.");
        }
    }
}
