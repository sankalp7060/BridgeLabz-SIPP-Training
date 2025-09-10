class LegacyAPI {
    @Deprecated
    void oldFeature() {
        System.out.println("This is an old feature (deprecated).");
    }

    void newFeature() {
        System.out.println("This is a new feature (recommended).");
    }
}

public class DepreCated {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature(); 
        api.newFeature();
    }
}
