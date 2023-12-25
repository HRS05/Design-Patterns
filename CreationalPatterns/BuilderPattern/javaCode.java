//interface of Builder

interface Builder {
    void setTypeOfCar(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
}


//Components of car 

class Engine {
    private String type;
    public Engine(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }

}

enum Transmission {
    SINGLE_SPEED, MANUAL, AUTOMATIC, SEMI_AUTOMATIC
}

enum CarType {
    CITY_CAR, SPORTS_CAR, SUV
}


class CarBuilder implements Builder {
    private CarType type;
    private int seats;
    private Engine engine;
    private Transmission transmission;

    public void setTypeOfCar(CarType type){
        this.type = type;
    }
    public void setSeats(int seats){
        this.seats = seats;
    }
    public void setEngine(Engine engine){
        this.engine = engine;
    }
    public void setTransmission(Transmission transmission){
        this.transmission = transmission;
    }
    public Car getResult() {
        return new Car(type, seats, engine, transmission);
    }
}


class CarManualBuilder implements Builder {
    private CarType type;
    private int seats;
    private Engine engine;
    private Transmission transmission;

    public void setTypeOfCar(CarType type){
        this.type = type;
    }
    public void setSeats(int seats){
        this.seats = seats;
    }
    public void setEngine(Engine engine){
        this.engine = engine;
    }
    public void setTransmission(Transmission transmission){
        this.transmission = transmission;
    }
    public Manual getManual() {
        return new Manual(type, seats, engine, transmission);
    }
}

//Car factory




class Car {
    private final CarType carType;
    private final int seats;
    private final Engine engine;
    private final Transmission transmission;
    private double fuel = 0;

    public Car(CarType carType, int seats, Engine engine, Transmission transmission) {
        this.carType = carType;
        this.seats = seats;
        this.engine = engine;
        this.transmission = transmission;
    }

    public CarType getCarType() {
        return carType;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getSeats() {
        return seats;
    }

    public Engine getEngine() {
        return engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

}

class Manual {
    private final CarType carType;
    private final int seats;
    private final Engine engine;
    private final Transmission transmission;

    public Manual(CarType carType, int seats, Engine engine, Transmission transmission) {
        this.carType = carType;
        this.seats = seats;
        this.engine = engine;
        this.transmission = transmission;
    }

    public String print() {
        String info = "";
        info += "Type of car: " + carType + "\n";
        info += "Count of seats: " + seats + "\n";
        info += "Engine: " + engine.getType() + "\n";
        info += "Transmission: " + transmission + "\n";
        return info;
    }
}



// Director 

class Director {
    public void constructSportsCar(Builder builder) {
        builder.setTypeOfCar(CarType.SPORTS_CAR);
        builder.setSeats(2);
        builder.setEngine(new Engine("Eight cylinder and above: V8"));
        builder.setTransmission(Transmission.SEMI_AUTOMATIC);
    }

    public void constructCityCar(Builder builder) {
        builder.setTypeOfCar(CarType.CITY_CAR);
        builder.setSeats(2);
        builder.setEngine(new Engine("1.3-litre SOHC 16-valve G13BB petrol engine"));
        builder.setTransmission(Transmission.AUTOMATIC);
    }

    public void constructSUV(Builder builder) {
        builder.setTypeOfCar(CarType.SUV);
        builder.setSeats(4);
        builder.setEngine(new Engine("Hybrid engine (Internal combustion engine + electric engine)"));
        builder.setTransmission(Transmission.MANUAL);
    }
}


//client code
class main {

    public static void main(String[] args) {
        Director director = new Director();

        CarBuilder builder = new CarBuilder();
        director.constructSportsCar(builder);

        Car car = builder.getResult();
        System.out.println("Car built:\n" + car.getCarType());


        CarManualBuilder manualBuilder = new CarManualBuilder();

        director.constructSportsCar(manualBuilder);
        Manual carManual = manualBuilder.getManual();
        System.out.println("\nCar manual built:\n" + carManual.print());
    }

}