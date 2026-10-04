package remote;

public class BasicRemote extends Remote {
    public BasicRemote(String id, Device device) {
        super(id, 30, device);
    }

    @Override
    public String execute() {
        return "BasicRemote[" + getId() + "] -> " + getDevice().applySettings(true, getPresetVolume());
    }
}