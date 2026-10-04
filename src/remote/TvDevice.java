package remote;

public class TvDevice implements Device {
    @Override
    public String applySettings(boolean power, int volume) {
        return "TV | power=" + (power ? "ON" : "OFF") + " | volume=" + volume;
    }
}