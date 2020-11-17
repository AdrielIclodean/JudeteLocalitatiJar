package com.judetelocalitati.romania;

import com.opencsv.CSVReader;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CSVValueAccessor {

    /**
     * @return map with key being the city and value a set with all it's counties
     */
    public static Map<String, Set<String>> readFile() {

        //"cod_judet","judet","localitate","resedinta_judet","oras"
        CSVReader reader;
        Map<String, Set<String>> citiesWithCounty = new LinkedHashMap<>();
        String[] line;
        try {
            reader = new CSVReader(new InputStreamReader(CSVValueAccessor.class.getClassLoader().getResourceAsStream("judete-localitati.csv")));
            while ((line = reader.readNext()) != null) {
                String city = line[1];
                String county = line[2];
                if (citiesWithCounty.get(city) == null) {
                    citiesWithCounty.put(city, new LinkedHashSet<String>());
                }
                citiesWithCounty.get(city).add(county);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return citiesWithCounty;
    }

    /**
     * Get all the counties for the given city
     *
     * @param city - City from Romania
     * @return - List with all the counties
     */
    public static List<String> getCountiesForCity(String city) {

        city = StringUtils.stripAccents(city);
        CSVReader reader;
        List<String> citiesWithCounty = new LinkedList<>();
        String[] line;
        try {
            reader = new CSVReader(new InputStreamReader(CSVValueAccessor.class.getClassLoader().getResourceAsStream("judete-localitati.csv")));
            boolean found = false;
            while ((line = reader.readNext()) != null) {
                String lineCity = line[1];
                String county = line[2];

                if (lineCity.equals(city)) {
                    found = true;
                }

                if (lineCity.equals(city) && found) {
                    citiesWithCounty.add(county);
                    continue;
                }

                if (found) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return citiesWithCounty;
    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        Map<String, Set<String>> citiesWithCounties = readFile();

        System.out.println(citiesWithCounties.get(StringUtils.stripAccents("Ilfov")));
        //"cod_judet","judet","localitate","resedinta_judet","oras"

        System.out.print("Cities time ");
        System.out.println(System.currentTimeMillis() - start);

        System.out.println(citiesWithCounties.keySet());

        System.out.println(getCountiesForCity("Arad"));
    }
}
