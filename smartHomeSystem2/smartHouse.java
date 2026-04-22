


interface RemoteControl{

    void turnOn();
    void turnOff();
}


abstract class Device{

    private String brand;
    public Device(String brand){
        this.brand = brand;
    }


    public String getBrand(){
        return this.brand;
    }
}

class Lamp extends Device implements RemoteControl{

    private boolean status = false;

    public Lamp(String brand){
        super(brand);
    }
    



    @Override
    public void turnOn(){
        if(status == true){
            System.out.println("Lamp is already on!");
        }
        else{
            System.out.println("Lamp has been turned on!");
            this.status = true;
        }
    }

    @Override
    public void turnOff(){

        if(status == true){
            System.out.println("Lamp has been turned off!");
            this.status = false;
        }
        else{
            System.out.println("Lamp is already off!");
        }
    }

}

class Toaster extends Device {
    
    public Toaster(String brand){
        super(brand);
    }


    public void toast(){
        System.out.print("Toasting bread");
    }
}


public class smartHouse{

    public static void pressPowerButton(RemoteControl device){
        System.out.println("Pressing the power button off");
        device.turnOff();
    }


    public static void main(String[] args){
        Lamp smartLamp = new Lamp("Dyson") ;
        smartLamp.turnOff();
        smartLamp.turnOff();
        smartLamp.turnOn();
        smartLamp.turnOn();
        smartLamp.turnOff();
        pressPowerButton(smartLamp);
    }
    
}

