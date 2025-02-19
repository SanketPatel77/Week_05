package convertjavaobjecttojson;

public class Car {
    private String model;
    private String engine;
    private String fuelType;

    public Car(String model, String engine, String fuelType) {
        this.model = model;
        this.engine = engine;
        this.fuelType = fuelType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
}
