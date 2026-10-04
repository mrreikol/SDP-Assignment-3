package remote;

public abstract class Remote {
    private final String id;
    private final int presetVolume;
    private Device device;

    public Remote(String id, int presetVolume, Device device) {
        if (id == null || device == null) {
            throw new IllegalArgumentException("ID and Device must not be null.");
        }
        this.id = id;
        this.presetVolume = presetVolume;
        this.device = device;
    }

    public String getId() {
        return id;
    }

    public int getPresetVolume() {
        return presetVolume;
    }

    public Device getDevice() {
        return device;
    }

    public void setImplementation(Device device) {
        if (device == null) {
            throw new IllegalArgumentException("Device cannot be null.");
        }
        this.device = device;
    }

    public abstract String execute();
}