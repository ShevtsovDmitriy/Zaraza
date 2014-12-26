package sample.Map;

import sample.Field.Country;
import sample.Field.Virus;

import java.util.List;

/**
 * Created by Alexander on 17.12.2014.
 */
public class Map {

    public Map(){};

    private List<Country> countries;
    public List<Country> getCountries(){return countries;}
    public void setCountries(List<Country> countries){this.countries=countries;}

    private Virus virus;
    public Virus getVirus(){return virus;}
    public void setVirus(Virus virus){this.virus=virus;}
}
