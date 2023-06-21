 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation;
import java.util.Random;


class Vehicle implements Runnable{
    private int id;
    private static Tollbooth toll = new Tollbooth();
    public Vehicle(int id){
       this.id = id; 
    }
    public void run(){
        System.out.println("Vehicle "+ (id+1)+" start journey ");
        Random RanGen = new Random();
        int Rnd = RanGen.nextInt(100);
        travel(Rnd);
        System.out.println("Vehicle"+ (id+1)+ "arrives at the toll");
        toll.useToll(this);
        travel(Rnd);
        System.out.println("Vehicle "+(id+1)+"has crossed the bridge");
    }    
    public int getVehicleId (){
        return this.id;
    }
    public void travel (int time){
        int limit = 5000000;
        for (int j=0; j < time; j++){
            for (int k=0; k < limit; k++);
        }
    }
}
class Tollbooth {
    boolean inUse;
    public Tollbooth(){
        inUse = false;  
    }
    public void useToll(Vehicle vehicle){
        while (true){
            if (inUse == false){
                synchronized (this){
                    inUse=true;
                    System.out.println("Vehicle"+(vehicle.getVehicleId()+1)+"enters tpplboth");
                    vehicle.travel(50);
                    System.out.println("Vehicle"+(vehicle.getVehicleId()+1)+"exits toolboth");
                    inUse  = false;
                    break;
                }
            }
        }
    }
}
public class Simulate{
    private static int noOfVehicles = 5;
    private static Vehicle[] vehicles;
    public static void main(String[] args){
        try{
            Simulate sm = new Simulate();
            vehicles= new Vehicle[5];
            for (int i=0; i<noOfVehicles; i++){
                vehicles[i]=new Vehicle(i);
                Thread t = new Thread(vehicles[i]);
                t.start();
                Thread.sleep(10);
            }
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }
}