package sample.Field;

import java.util.List;

/**
 * Created by Alexander on 17.12.2014.
 */
public class Country {

    public Country(){};

    private String name;
    public String getName(){return name;}
    public void setName(String name){this.name=name;}

    private int populations;
    public int getPopulations(){return populations;}
    public void setPopulations(int populations){this.populations=populations;}

    private int defence;
    public int getDefence(){return defence;}
    public void setDefence(int defence){this.defence=defence;}

    private int waterPositionCoef;
    public int getWaterPositionCoef(){return waterPositionCoef;}
    public void setWaterPositionCoef(int waterPositionCoef){this.waterPositionCoef=waterPositionCoef;}

    private int airPositionCoef;
    public int getAirPositionCoef(){return airPositionCoef;}
    public void setAirPositionCoef(int airPositionCoef){this.airPositionCoef=airPositionCoef;}

    private int animalPositionCoef;
    public int getAnimalPositionCoef(){return animalPositionCoef;}
    public void setAnimalPositionCoef(int animalPositionCoef){this.animalPositionCoef=animalPositionCoef;}

    private int area;
    public int getArea(){return area;}
    public void setArea(int area){this.area=area;}

    private List<Country> neighbors;
    public List<Country> getNeighbors(){return neighbors;}
    public void setNeighbors(List<Country> neighbors){this.neighbors=neighbors;}

    private int exportVirusCoef;
    public int getExportVirusCoef(){return exportVirusCoef;}
    public void setExportVirusCoef(int exportVirusCoef){this.exportVirusCoef=exportVirusCoef;}

    private int infected;
    public int getInfected(){return infected;}
    public void setInfected(int infected){this.infected=infected;}

    private boolean hasInfected;
    public boolean getHasInfected(){return hasInfected;}
    public void setHasInfected(boolean hasInfected){this.hasInfected=hasInfected;}

    public void upgradeDefence(){
        defence+=1;
    }

    public void createCure(){
        //Отношение зараженных к общей численности
        if(infected*1.0/populations>0.3){
            recovery();
        }
    }

    public void infecting(){
        //2,3 и 8 - коэффициенты "серьезности" среды распространения
        infected+=animalPositionCoef*2+waterPositionCoef*3+airPositionCoef*8;
    }

    public void recovery(){
        //Количество выздоравливаемых за тик
        infected-=10*defence;
    }

    public void dying(){
        //Количество умирающих за тик
        //Если 70% населения заражено, то смертоностность увеличивается в 10 раз.
        infected-=5;
        populations-=5;
        if (infected*1.0/populations>0.7){
            infected-=50;
            populations-=50;
        }
    }
}
