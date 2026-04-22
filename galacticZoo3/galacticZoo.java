import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

interface Flyable{
    void fly();
}

abstract class Alien{

    private SpeciesType species;
    private int dangerLevel;

    public Alien(SpeciesType species, int dangerLevel){
        this.species = species;
        this.dangerLevel = dangerLevel;
    }


    public SpeciesType getSpecies(){
        return this.species;
    }
    public int getDangerLevel(){
        return this.dangerLevel;
    }
}

class Martian extends Alien implements Flyable{


    public Martian(SpeciesType species, int dangerLevel){
        super (species,dangerLevel);
    }

    @Override
    public void fly(){
        System.out.println(getSpecies()+" can fly");
    }
}

class Jovial extends Alien{


    public Jovial(SpeciesType species, int dangerLevel){
        super (species,dangerLevel);
    }

    
}



public class galacticZoo{

    public static void readDataAliens(Scanner scan ,ArrayList<Alien> zoo){
        while(scan.hasNext()){
            try{
            System.out.println("READ!");
            String speciesStr = scan.next();  // martian jovial
            String subtypeStr = scan.next(); //beta alpha
            int level = scan.nextInt(); // 1, 2 , 3

            SpeciesType sType = SpeciesType.valueOf(speciesStr.toUpperCase());

            System.out.println(sType.toString()+" "+subtypeStr+" "+level);
            
            if (sType == SpeciesType.MARTIAN){
                
                zoo.add(new Martian(sType,level));
                System.out.println("Added to zoo new "+sType);
            }
            else
                if(sType == SpeciesType.JOVIAL){
                    
                    zoo.add(new Jovial(sType, level));
                    System.out.println("Added to zoo new "+sType.toString());
                }
            }
            catch(IllegalArgumentException e){
                System.out.print("UNKNOWN  SPECIES FOUND IN FILE");
            }

            catch(Exception e ){
                System.out.println("corrupted or unknown line");
                if (scan.hasNextLine()){
                    scan.nextLine();
                }
            }
        }
    }

    public static void main(String[] args){

        ArrayList<Alien> zoo = new ArrayList<>(); 
        
        try {

        System.out.println(args[0]);
        File myFile = new File(args[0]);
        Scanner scan = new Scanner(myFile);

        readDataAliens(scan,zoo);

        scan.close();
        
        System.out.println("");

        //System.out.println(zoo.size());
        
        /*for(int i=0;i<zoo.size();i++){ 
            Alien temp = zoo.get(i);
            System.out.println("Species : "+temp.getSpecies()+"\n Danger level: "+temp.getDangerLevel());
        }*/
        
        }

        catch(FileNotFoundException e ){
            System.out.print("cannot find file");
        }

        for(Alien a :zoo){
                    if (a instanceof Flyable){
                        Flyable temp = (Flyable) a;
                        temp.fly();
                    }

                    System.out.println("Species : "+a.getSpecies()+"\n Danger level: "+a.getDangerLevel());
                }
    }
}

