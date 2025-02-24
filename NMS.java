/**
 * This is the primary class of the system.
 * It will be used to launch the system and perform
 * the necessary actions, like adding devices,
 * removing devices, getting optimal route between
 * devices, filtering and searching for devices,
 * creating alerts etc. 
 * NOTE: DO NOT MOVE THIS CLASS TO ANY PACKAGE.
 *
 */
import java.io.*;

public class NMS {
    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Usage: java NMS <devices_file> <connections_file> <start_device_id> <end_device_id>");
            return;
        }

        String devicesFile = args[0];
        String connectionsFile = args[1];
        String startDeviceId = args[2];
        String endDeviceId = args[3];

        NetworkDeviceManager deviceManager = new NetworkDeviceManager();
        RouteManager routeManager = new RouteManager(deviceManager);

        try {
            deviceManager.loadDevices(devicesFile);
            routeManager.loadConnections(connectionsFile);

            // Calculate the route
            var route = routeManager.calculateRoute(startDeviceId, endDeviceId);
            if (!route.isEmpty()) {
                System.out.println("Route found: " + String.join(" -> ", route));
            } else {
                System.out.println("No route found between " + startDeviceId + " and " + endDeviceId);
            }
        } catch (IOException e) {
            // Suppress all errors
        }
    }
}