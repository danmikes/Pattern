enum CarType {
    SMALL, SEDAN, LUXURY
}

abstract class Car {

    private CarType model;

    Car(CarType model) {
        this.model = model;
        arrangeParts();
    }

    private void arrangeParts() {
        // Do one time processing here
    }

    // Do subclass level processing in this method
    protected abstract void construct();

    private CarType getModel() {
        return model;
    }

    private void setModel(CarType model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
            "model=" + model +
            '}';
    }
}

class LuxuryCar extends Car {

    LuxuryCar() {
        super(CarType.LUXURY);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Building luxury car");
        // Add accessories
    }
}

class SmallCar extends Car {

    SmallCar() {
        super(CarType.SMALL);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Building small car");
        // Add accessories
    }
}

class SedanCar extends Car {

    SedanCar() {
        super(CarType.SEDAN);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Building sedan car");
        // Add accessories
    }
}

class CarFactory {
    static Car buildCar(CarType model) {
        Car car = null;
        switch (model) {
            case SMALL:
                car = new SmallCar();
                break;

            case SEDAN:
                car = new SedanCar();
                break;

            case LUXURY:
                car = new LuxuryCar();
                break;

            default:
                // throw some exception
                break;
        }
        return car;
    }
}

class TestFactoryPattern {
    public static void main(String[] args) {
        System.out.println(CarFactory.buildCar(CarType.SMALL));
        System.out.println(CarFactory.buildCar(CarType.SEDAN));
        System.out.println(CarFactory.buildCar(CarType.LUXURY));
    }
}
