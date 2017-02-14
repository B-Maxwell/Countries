/*
This class creates a Country Processor object and calls the
 */

public class Main {

    public static void main(String[] args) throws Exception {

        CountryProcessor processor = new CountryProcessor();

        processor.loadCountries();
        processor.loadCountryHashMap();
        processor.createFile();

    }
}












