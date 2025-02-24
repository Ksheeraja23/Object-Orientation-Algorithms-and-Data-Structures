# Object Orientation Algorithms and Data Structures
## Overview
This repository contains the implementation of a Network Management System (NMS) designed to monitor, configure, and manage network devices in real-time. The project utilizes Object-Oriented principles and appropriate data structures to ensure maintainability and scalability.

# Project Components
## Core Classes:
1. NMS.java: The main entry point of the application, handling user input and orchestrating functionality.
2. DeviceConfiguration.java: Represents the configuration of network devices, including attributes like MAC address and IP address.
3. NetworkDevice.java: Encapsulates properties and behaviors of network devices, serving as a base class for specific device types (e.g., Router, Switch).
4. NetworkDeviceManager.java: Manages a list of network devices and provides methods to extract device information.
5. RouteManager.java: Manages connections between devices and finds optimal routes using the Breadth-First Search (BFS) algorithm.
6. LoggingManager.java: Handles logging of events and actions performed by the system.

## Key Features
- Object-Oriented Design: Utilizes encapsulation, inheritance, and polymorphism to enhance code organization and reduce duplication.
- BFS Algorithm: Implements the Breadth-First Search algorithm to calculate the shortest path between network devices, ensuring efficient real-time queries.
- Input Validation: Incorporates strategies for handling incorrect or invalid inputs, including file format checks and exception handling.
- Future Scalability: Designed to easily accommodate new device types, weighted connections, and path calculations from one device to all others.

## Technologies Used
1. Java Programming Language
2. UML Diagrams for system visualization
3. Data Structures (Queues, Maps)

## Getting Started
1. Clone the repository to your local machine.
2. Compile the Java files using a Java compiler.
3. Run the NMS.java file to start the application.

## Conclusion
The NMS project effectively demonstrates the application of Object-Oriented principles in software design, providing a robust solution for managing network devices and optimizing routing paths. This repository serves as a practical example of implementing algorithms and data structures in a real-world context.
