package remote;

public class ProjectorDevice implements Device {
    @Override
    public String applySettings(boolean power, int volume) {
        return "PROJECTOR | power=" + (power ? "ON" : "OFF") + " | volume=" + volume;
    }
}