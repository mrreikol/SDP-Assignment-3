import remote.*;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0 || !args[0].equals("--demo")) {
            System.out.println("Usage: java -cp out Main --demo");
            return;
        }

        int passed = 0;
        int total = 7;

        Device tv = new TvDevice();
        Device radio = new RadioDevice();

        Remote basicTv = new BasicRemote("R-B1", tv);
        String t1Expected = "BasicRemote[R-B1] -> TV | power=ON | volume=30";
        String t1Actual = basicTv.execute();
        boolean t1Pass = t1Actual.equals(t1Expected);
        if (t1Pass) passed++;
        System.out.println("T1 " + (t1Pass ? "PASS" : "FAIL") + " | BasicRemote + TvDevice | result=" + t1Actual);
        if (!t1Pass) System.out.println("   Expected: " + t1Expected);

        Remote basicRadio = new BasicRemote("R-B1", radio);
        String t2Expected = "BasicRemote[R-B1] -> RADIO | power=ON | volume=30";
        String t2Actual = basicRadio.execute();
        boolean t2Pass = t2Actual.equals(t2Expected);
        if (t2Pass) passed++;
        System.out.println("T2 " + (t2Pass ? "PASS" : "FAIL") + " | BasicRemote + RadioDevice | result=" + t2Actual);
        if (!t2Pass) System.out.println("   Expected: " + t2Expected);

        Remote quietTv = new QuietRemote("R-Q1", tv);
        String t3Expected = "QuietRemote[R-Q1] -> TV | power=ON | volume=5";
        String t3Actual = quietTv.execute();
        boolean t3Pass = t3Actual.equals(t3Expected);
        if (t3Pass) passed++;
        System.out.println("T3 " + (t3Pass ? "PASS" : "FAIL") + " | QuietRemote + TvDevice | result=" + t3Actual);
        if (!t3Pass) System.out.println("   Expected: " + t3Expected);

        Remote quietRadio = new QuietRemote("R-Q1", radio);
        String t4Expected = "QuietRemote[R-Q1] -> RADIO | power=ON | volume=5";
        String t4Actual = quietRadio.execute();
        boolean t4Pass = t4Actual.equals(t4Expected);
        if (t4Pass) passed++;
        System.out.println("T4 " + (t4Pass ? "PASS" : "FAIL") + " | QuietRemote + RadioDevice | result=" + t4Actual);
        if (!t4Pass) System.out.println("   Expected: " + t4Expected);

        Remote switchRemote = new BasicRemote("R-SW", tv);
        Remote refBefore = switchRemote;
        String resBefore = switchRemote.execute();

        switchRemote.setImplementation(radio);
        Remote refAfter = switchRemote;
        String resAfter = switchRemote.execute();

        boolean sameObject = (refBefore == refAfter);
        boolean stateUnchanged = switchRemote.getId().equals("R-SW") && switchRemote.getPresetVolume() == 30;
        boolean t5Pass = sameObject && stateUnchanged
                && resBefore.equals("BasicRemote[R-SW] -> TV | power=ON | volume=30")
                && resAfter.equals("BasicRemote[R-SW] -> RADIO | power=ON | volume=30");
        if (t5Pass) passed++;
        System.out.println("T5 " + (t5Pass ? "PASS" : "FAIL") + " sameObject=" + sameObject + " | stateUnchanged=" + stateUnchanged);
        System.out.println("   before=" + resBefore + " | after=" + resAfter);

        Device projector = new ProjectorDevice();

        Remote basicProj = new BasicRemote("R-B1", projector);
        String t6Expected = "BasicRemote[R-B1] -> PROJECTOR | power=ON | volume=30";
        String t6Actual = basicProj.execute();
        boolean t6Pass = t6Actual.equals(t6Expected);
        if (t6Pass) passed++;
        System.out.println("T6 " + (t6Pass ? "PASS" : "FAIL") + " | BasicRemote + ProjectorDevice | result=" + t6Actual);
        if (!t6Pass) System.out.println("   Expected: " + t6Expected);

        Remote quietProj = new QuietRemote("R-Q1", projector);
        String t7Expected = "QuietRemote[R-Q1] -> PROJECTOR | power=ON | volume=5";
        String t7Actual = quietProj.execute();
        boolean t7Pass = t7Actual.equals(t7Expected);
        if (t7Pass) passed++;
        System.out.println("T7 " + (t7Pass ? "PASS" : "FAIL") + " | QuietRemote + ProjectorDevice | result=" + t7Actual);
        if (!t7Pass) System.out.println("   Expected: " + t7Expected);

        System.out.println("SUMMARY: " + passed + "/" + total + " PASS");
    }
}