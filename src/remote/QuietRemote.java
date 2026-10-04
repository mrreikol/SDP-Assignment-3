package remote;

public class QuietRemote extends Remote {
    public QuietRemote(String id, Device device) {
        super(id, 5, device);
    }

    @Override
    public String execute() {
        return "QuietRemote[" + getId() + "] -> " + getDevice().applySettings(true, getPresetVolume());
    }
}