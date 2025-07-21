// SensorReadable interface
interface SensorReadable {
    void readSensorData();
}

// Base class
class IrrigationUnit implements SensorReadable {
    private double calibrationFactor;

    public IrrigationUnit() {
        this.calibrationFactor = 1.0;
    }

    public void calibrate(double factor) {
        if (factor > 0) {
            this.calibrationFactor = factor;
        }
    }

    public void startWatering() {
        System.out.println("Starting basic irrigation...");
    }

    public void readSensorData() {
        System.out.println("Reading default sensor data...");
    }
}

// Derived class: Sprinkler
class Sprinkler extends IrrigationUnit {
    public Sprinkler() {
        super();
    }

    @Override
    public void startWatering() {
        System.out.println("Sprinkler started watering with rotation.");
    }
}

// Derived class: DripSystem
class DripSystem extends IrrigationUnit {
    public DripSystem() {
        super();
    }

    @Override
    public void startWatering() {
        System.out.println("Drip system started watering roots precisely.");
    }
}

// Main
public class AgroBotSystem {
    public static void main(String[] args) {
        IrrigationUnit unit1 = new Sprinkler();
        IrrigationUnit unit2 = new DripSystem();

        unit1.readSensorData();
        unit1.startWatering();

        unit2.readSensorData();
        unit2.startWatering();
    }
}
