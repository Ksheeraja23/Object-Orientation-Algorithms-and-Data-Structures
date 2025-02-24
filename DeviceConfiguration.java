public class DeviceConfiguration {
    private String interfaceType;
    private String macAddress;
    private String ipAddress;
    private String subnetMask;

    public DeviceConfiguration(String interfaceType, String macAddress, String ipAddress, String subnetMask) {
        this.interfaceType = interfaceType;
        this.macAddress = macAddress;
        this.ipAddress = ipAddress;
        this.subnetMask = subnetMask;
    }

    public String getInterfaceType() {
        return interfaceType;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getSubnetMask() {
        return subnetMask;
    }

    @Override
    public String toString() {
        return "Interface: " + interfaceType + ", MAC: " + macAddress + ", IP: " + ipAddress + ", Subnet: " + subnetMask;
    }
}
