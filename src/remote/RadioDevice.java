package remote;

public class RadioDevice implements Device {
    @Override
    public String applySettings(boolean power, int volume) {
        return "RADIO | power=" + (power ? "ON" : "OFF") + " | volume=" + volume;
    }
}