package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Stefan
 */
public class FileBackend implements MainModel {

    private List<Film> data;
    private String fileName = "movies.txt"; //Standard-FILE
    private final List<Film> eData = new ArrayList<>();

    @Override
    public List<Film> getData() {
        URL url = this.getClass().getResource(fileName);
        System.out.println(url); //TEST
        if (url != null) {
            System.out.println(fileName);
            if (".txt".equals(url.toString().substring(url.toString().length() - 4))) {
                return getDataTXT(getClass().getResourceAsStream(fileName));
            } else if (".csv".equals(url.toString().substring(url.toString().length() - 4))) {
                return getDataCSV(getClass().getResourceAsStream(fileName));
            } else {
                System.out.println("kein unterstütztes File");//TEST
                return eData;
            }

        } else {
            System.out.println("kein File");//TEST
            return eData;
        }
    }

    @Override
    public void setFileName(String name) {
        this.fileName = name;
    }

    public List<Film> getDataTXT(InputStream iStream) {
        data = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(iStream))) {
            bufferedReader.lines().skip(1).forEach(e -> {
                String[] col = e.split(";");
                data.add(new Film(
                        Integer.parseInt(col[0]), //ID
                        col[1], //TITLE
                        Integer.parseInt(col[2]), //YEARofAWARD
                        col[3], //DIRECTOR
                        col[4], //MAINACTOR
                        col[5], //TITLEeng
                        Integer.parseInt(col[6]), //YEARofPRODUCTION
                        col[7], //COUNTRY
                        Integer.parseInt(col[8]), //DURATION
                        Integer.parseInt(col[9]), //FSK
                        col[10], //GENRE
                        col[11], //STARTDate
                        Integer.parseInt(col[12]))); //NUMBERofOSKARS
            });
//TEST
            data.stream().forEach((f) -> {
                System.out.println(f.getTitle());
            });
//TEST

        } catch (IOException exception) {
            System.out.println("falsche Daten");
            System.out.println("General I/O exception: " + exception.getMessage());
        }
        return data;

    }

    public List<Film> getDataCSV(InputStream iStream) {
        data = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(iStream))) {
            bufferedReader.lines().skip(1).forEach(e -> {
                String[] col = e.split(";");
                data.add(new Film(
                        Integer.parseInt(col[0]), //ID
                        col[1], //TITLE
                        Integer.parseInt(col[2]), //YEARofAWARD
                        col[3], //DIRECTOR
                        col[4], //MAINACTOR
                        col[5], //TITLEeng
                        Integer.parseInt(col[6]), //YEARofPRODUCTION
                        col[7], //COUNTRY
                        Integer.parseInt(col[8]), //DURATION
                        Integer.parseInt(col[9]), //FSK
                        col[10], //GENRE
                        col[11], //STARTDate
                        Integer.parseInt(col[12]))); //NUMBERofOSKARS
            });
//TEST
            data.stream().forEach((f) -> {
                System.out.println(f.getTitle());
            });
//TEST

        } catch (IOException exception) {
            System.out.println("falsche Daten");
            System.out.println("General I/O exception: " + exception.getMessage());
        }
        return data;

    }

}
