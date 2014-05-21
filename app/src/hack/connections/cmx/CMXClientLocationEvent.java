package hack.connections.cmx;

public class CMXClientLocationEvent {

    private String ipv4;
    private String macAddr;
    private long lastLocated;
    private double lat;
    private double lng;

    public CMXClientLocationEvent(String macAddr, String ipv4, long lastLocated, double lat, double lng) {
        this.macAddr = macAddr;
        this.ipv4 = ipv4;
        this.lastLocated = lastLocated;
        this.lat = lat;
        this.lng = lng;
    }

    public double distance(CMXClientLocationEvent other) {
        // TODO: consider time distance
        double dlat = Math.abs(this.lat - other.lat);
        double dlng = Math.abs(this.lng - other.lng);
        return Math.sqrt(Math.pow(dlat, 2) + Math.pow(dlng, 2));
    }

    public String toString() {
        return String.format("CLE[ipv4=%s, macaddr=%s at (%s,%s) time=%s]", ipv4, macAddr, lat, lng, lastLocated);
    }
}
