package sample;

import org.json.JSONArray;
import org.json.JSONObject;
import sample.Field.Country;
import sample.Field.Virus;
import sample.Map.Map;

import java.util.*;

/**
 * Created by Alexander on 18.12.2014.
 */
public class Parser {

    public Parser(){};

    String wayToCountries="C:\\Users\\Alexander\\Desktop\\Study\\The Plague\\Counties.json";
    String wayToVirus="C:\\Users\\Alexander\\Desktop\\Study\\The Plague\\Virus.json";

    public Map toParseAllMap(String jsonCountries,String jsonVirus){
        //Input strings - pathway to .JSON

        Map mainGame=new Map();

        mainGame.setVirus(toParseVirus(jsonVirus));
        mainGame.setCountries(toParseCountry(jsonCountries));

        return mainGame;
    }

    public List<Country> toParseCountry(String str){
        List<Country> result=new ArrayList<Country>();
        List<JSONObject> objects=new ArrayList<JSONObject>();

        try{
            JSONArray array=new JSONArray(str);
            for (int i=0;i<objects.size();i++){
                objects.add(array.getJSONObject(i));
            }

            for (int i=0;i<objects.size();i++){
                result.get(i).setName(objects.get(i).getString("name"));
                result.get(i).setPopulations(objects.get(i).getInt("populations"));
                result.get(i).setDefence(objects.get(i).getInt("defence"));
                result.get(i).setWaterPositionCoef(objects.get(i).getInt("waterPositionCoef"));
                result.get(i).setAirPositionCoef(objects.get(i).getInt("airPositionCoef"));
                result.get(i).setAnimalPositionCoef(objects.get(i).getInt("animalPositionCoef"));
                result.get(i).setArea(objects.get(i).getInt("area"));
                result.get(i).setExportVirusCoef(objects.get(i).getInt("exportVirusCoef"));
                result.get(i).setInfected(objects.get(i).getInt("infected"));
                result.get(i).setHasInfected(objects.get(i).getBoolean("hasInfected"));
            }

            //FOR RUSSIA
            List<Country> neighbours1=new ArrayList<Country>();
            neighbours1.add(result.get(2));
            neighbours1.add(result.get(3));
            neighbours1.add(result.get(4));
            neighbours1.add(result.get(1));
            result.get(0).setNeighbors(neighbours1);

            //FOR USA
            List<Country> neighbours2=new ArrayList<Country>();
            neighbours2.add(result.get(0));
            neighbours2.add(result.get(4));
            result.get(1).setNeighbors(neighbours2);

            //FOR GERMANY
            List<Country> neighbours3=new ArrayList<Country>();
            neighbours3.add(result.get(0));
            neighbours3.add(result.get(3));
            result.get(2).setNeighbors(neighbours3);

            //FOR SWEDEN
            List<Country> neighbours4=new ArrayList<Country>();
            neighbours4.add(result.get(0));
            neighbours4.add(result.get(2));
            result.get(3).setNeighbors(neighbours4);

            //FOR MEXICO
            List<Country> neighbours5=new ArrayList<Country>();
            neighbours5.add(result.get(0));
            neighbours5.add(result.get(1));
            result.get(4).setNeighbors(neighbours5);

        }
        catch(Exception e){

        }
        return result;
    /*
         defence - 20ти балльная шкала
         water\air\animalPositionCoef - 20ти балльная шкала
         area - 100а балльная шкала (относительно России)
         exportVirusCoef - 20ти балльная шкала

        str like:
        [
            {
                "name" : "Russia",
                "populations" : "140000000",
                "defence" : "7",
                "waterPositionCoef" : "6",
                "airPositionCoef" : "13",
                "animalPositionCoef : "10",
                "area" : "100",
                "neighbors" : [
                                  Массив из стран-соседей, копипаст
                                  {
                                      Страна-сосед
                                  }...
                              ],
                "exportVirusCoef" : "11",
                "infected" : "0",
                "hasInfected" : "false",
            }

            {
                //Другая страна
            }...
        ]
    */
    }

    public Virus toParseVirus(String str){
        Virus result=new Virus();

        try {
            JSONObject reader = new JSONObject(str);
            result.setName(reader.getString("name"));
            result.setWaterAttackInfectivity(reader.getInt("waterAttackInfectivity"));
            result.setAirAttackInfectivity(reader.getInt("airAttackInfectivity"));
            result.setAnimalAttackInfectivity(reader.getInt("animalAttackInfectivity"));
            result.setLethality(reader.getInt("lethality"));
            result.setLevel(reader.getInt("level"));
            List<Country> infected=new ArrayList<Country>();
            result.setInfected(infected);
        } catch (Exception e){

        }
        return result;
        /*В начале игры будет возможность выбрать вирус (один лучше уничтожает, но плохо распространяется,
                                                         другой-наоборот, третий - среднее).
          Каждый вирус будет расположен в отдельном JSON-файле, который парсится только после выбора игроком оного.

            Str like:
            {
                "name" : "Ebola",
                "waterAttackInfectivity" : "8",
                "airAttackInfectivity" : "16",
                "animalAttackInfectivity" : "15",
                "lethality" : "7",
                "level" : "1",
                "infected" : [
                                Изначально - пусто
                             ],
            }
        */

    }
}
