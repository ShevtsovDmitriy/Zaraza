package sample.Field;

import java.util.List;

/**
 * Created by Alexander on 17.12.2014.
 */
public class Virus {

    public Virus(){};

    private String name;
    public String getName(){return name;}
    public void setName(String name){this.name=name;}

    private int waterAttackInfectivity;
    public int getWaterAttackInfectivity(){return waterAttackInfectivity;}
    public void setWaterAttackInfectivity(int waterAttackInfectivity){this.waterAttackInfectivity = waterAttackInfectivity;}

    private int airAttackInfectivity;
    public int getAirAttackInfectivity(){return airAttackInfectivity;}
    public void setAirAttackInfectivity(int airAttackInfectivity){this.airAttackInfectivity = airAttackInfectivity;}

    private int animalAttackInfectivity;
    public int getAnimalAttackInfectivity(){return animalAttackInfectivity;}
    public void setAnimalAttackInfectivity(int animalAttackInfectivity){this.animalAttackInfectivity = animalAttackInfectivity;}

    private int lethality;
    public int getLethality(){return lethality;}
    public void setLethality(int lethality){this.lethality = lethality;}

    private int level;
    public int getLevel(){return level;}
    public void setLevel(int level){this.level=level;}

    private List<Country> infected;
    public List<Country> getInfected(){return infected;}
    public void setInfected(List<Country> infected){this.infected=infected;}




    public void lethalityUpgrade(){
        lethality=lethality*level;
    }

    public void infectivityUpgrade(){
        waterAttackInfectivity=waterAttackInfectivity*level;
        airAttackInfectivity=airAttackInfectivity*level;
        animalAttackInfectivity=animalAttackInfectivity*level;
    }

    public void infect(Country selectedCountry){
        if (!selectedCountry.getHasInfected()){
            selectedCountry.setHasInfected(true);
        }
    }

    public void export(){
        for (Country country: infected){
            for (Country neighbor: country.getNeighbors()){
                if ((Math.random()*10==1)&&(neighbor.getDefence()/(2*level)<1)){
                    infect(neighbor);
                }
                if(country.getExportVirusCoef()>14){
                    if(Math.random()*3==2){
                        infect(neighbor);
                    }
                }
            }
        }
    }
}
