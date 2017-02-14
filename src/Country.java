

/**
 * Created by MacbookStudioPro on 2/10/17.
 */
public class Country {

    String abbrev;
    String countryName;


    public Country(String abbrev, String countryName) {
        this.abbrev = abbrev;
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return String.format("%s ", countryName);
    }
}
