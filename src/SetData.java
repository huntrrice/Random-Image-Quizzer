// csv should be formatted with answers in first collumn and image names in second
// images should be in folder with matching names to second collumn of csv

public class SetData {
    public static String getCsv() {
        // input csv path here, only change contents in qoutes
        // example: "src/Data/CountryGuessing/Countries.csv"
        return "src/Data/CountryGuessing/Countries.csv";
    }

    public static String getImageFolder() {
        // input image folder path here, only change contents of first quotes
        // example: "src/Data/CountryGuessing/Flags"
        return "src/Data/CountryGuessing/Flags" + "/";
    }
}
