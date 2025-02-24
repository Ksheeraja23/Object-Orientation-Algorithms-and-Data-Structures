/**
 * This class primarily does the calculation of
 * routes between devices. The actions will be based
 * on the devices added to a particular route.
 * The devices added here should be a subset of the ones
 * added to the NetworkDeviceManager. You shouldn't add
 * a device to the RouteManager if they aren't in the
 * NetworkDeviceManager. 
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class RouteManager {
    private NetworkDeviceManager deviceManager;
    private Map<String, List<String>> connections;

    public RouteManager(NetworkDeviceManager deviceManager) {
        this.deviceManager = deviceManager;
        connections = new HashMap<>();
    }

    public void loadConnections(String connectionsFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(connectionsFile));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(", ");
            if (parts.length < 2) {
                continue; // Skip this line if it doesn't have enough parts
            }
            String device1 = parts[0].trim();
            String device2 = parts[1].trim();
            connections.putIfAbsent(device1, new ArrayList<>());
            connections.putIfAbsent(device2, new ArrayList<>());
            connections.get(device1).add(device2);
            connections.get(device2).add(device1);
        }
        reader.close();
    }

    public List<String> calculateRoute(String startDeviceId, String endDeviceId) {
        Set<String> visited = new HashSet<>();
        Queue<List<String>> queue = new LinkedList<>();
        queue.add(Arrays.asList(startDeviceId));

        while (!queue.isEmpty()) {
            List<String> path = queue.poll();
            String currentDevice = path.get(path.size() - 1);

            if (currentDevice.equals(endDeviceId)) {
                return path; // Return the path if the end device is reached
            }

            if (!visited.contains(currentDevice)) {
                visited.add(currentDevice);
                List<String> neighbors = connections.getOrDefault(currentDevice, new ArrayList<>());
                for (String neighbor : neighbors) {
                    List<String> newPath = new ArrayList<>(path);
                    newPath.add(neighbor);
                    queue.add(newPath);
                }
            }
        }
        return Collections.emptyList(); // Return empty if no route is found
    }
}