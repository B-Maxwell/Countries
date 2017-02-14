import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by MacbookStudioPro on 2/14/17.
 */
public class CountryProcessor {

    ArrayList<Country> countries = new ArrayList<>();
    Map<String, ArrayList<Country>> countryHashMap = new HashMap<>();

    public void loadCountries() throws FileNotFoundException {
        File f = new File("countries.txt");
        Scanner scanner = new Scanner(f);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] columns = line.split("\\|");
            Country countryInfo = new Country((columns[0]), columns[1]);
            countries.add(countryInfo); //loads all country data into the country array list
        }
    }

    public void loadCountryHashMap() {
        for (Country country : countries) {
            String letter = country.countryName.substring(0, 1);
            ArrayList<Country> countryBeginningWithLetter = countryHashMap.get(letter);

            if (countryBeginningWithLetter == null) {
                countryBeginningWithLetter = new ArrayList<>();
            }
            countryBeginningWithLetter.add(country);
            countryHashMap.put(letter, countryBeginningWithLetter);
        }

    }

    public void createFile() throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the first letter of the countries that you would like to list.");
        String countryLetter = input.nextLine();
        if (!countryLetter.isEmpty()) {
            writeFileInfo(countryLetter);
        } else {
            throw new Exception ("Input cannot be blank!");
        }
    }

    public void writeFileInfo(String letter) throws Exception {
        File output = new File(letter.toUpperCase() + "_countries.txt");
        FileWriter fw = new FileWriter(output);
        for (Country country : countries) {
            if (country.countryName.startsWith(letter.toLowerCase())) {
                System.out.printf("%s | %s\n", letter, country.countryName);
                fw.write(String.format("%s\n", country.countryName));
            }
        }
        fw.close();
        System.out.println("-------------------------------");
        System.out.println("The above countries were written to your file.");
    }

}
