/**
 * This class acts as a manager class through which
 * the devices represented by NetworkDevice shall be
 * maintained. This class shall allow adding and
 * removing of devices, and also set configuration
 * for each device added to it. Any other class should use
 * this class to get the latest set of devices maintained
 * by the system.
 * Note: The list of devices should not be held in any
 * other class.
 */
import java.io.*;
import java.util.*;

public class NetworkDeviceManager {
    private List<NetworkDevice> devices;

    public NetworkDeviceManager() {
        devices = new ArrayList<>();
    }

    public void loadDevices(String devicesFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(devicesFile));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(", ");
            if (parts.length < 2) {
                continue; // Skip this line if it doesn't have enough parts
            }

            String id = parts[0].trim();
            String type = parts[1].trim();
            DeviceConfiguration config = null;

            try {
                if (type.equals("PC ")) {
                    String interfaceType = parts[2].trim();
                    String macAddress = parts[3].trim();
                    String ipAddress = parts[4].trim();
                    String subnetMask = parts[5].trim();
                    config = new DeviceConfiguration(interfaceType, macAddress, ipAddress, subnetMask);
                    devices.add(new NetworkDevice.PC(id, config));
                } else if (type.equals("Router")) {
                    int routingTableSize = Integer.parseInt(parts[2].trim());
                    devices.add(new NetworkDevice.Router(id, routingTableSize));
                } else if (type.equals("Switch")) {
                    int numberOfPorts = Integer.parseInt(parts[2].trim());
                    devices.add(new NetworkDevice.Switch(id, numberOfPorts));
                } else if (type.equals("Firewall")) {
                    devices.add(new NetworkDevice.Firewall(id));
                }
            } catch (Exception e) {
                // Suppress any errors related to device creation
            }
        }
        reader.close();
    }

    public List<NetworkDevice> getDevices() {
        return devices;
    }
}