import java.lang.String;
public class Place {
    private int localId; // Local database ID (auto-increment)
    private int webPrimaryId; // Web service's primary ID

    // Constructor, getters, and setters
    public Place(int localId, int webPrimaryId) {
        this.localId = localId;
        this.webPrimaryId = webPrimaryId;
    }

    public int getLocalId() {
        return localId;
    }

    public void setLocalId(int localId) {
        this.localId = localId;
    }

    public int getWebPrimaryId() {
        return webPrimaryId;
    }

    public void setWebPrimaryId(int webPrimaryId) {
        this.webPrimaryId = webPrimaryId;
    }

	public static void main(String[] args) {
	}
}