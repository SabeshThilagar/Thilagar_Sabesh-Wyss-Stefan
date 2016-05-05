package Model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Stefan
 */
public class FileBackend implements MainModel {

    private List<Film> data;

    @Override
    public List<Film> getData() {
        //return getData(getClass().getResourceAsStream("movies.csv"));
        return getData(getClass().getResourceAsStream("movies_1.txt"));
    }

    /**
     * returns the data from a given file
     *
     * @param path the name of the given file
     * @return the election results
     */
    public List<Film> getData(String path) {
        try {
            return getData(new FileInputStream(path));
        } catch (FileNotFoundException ex) {
            // TODO
        }
        return null;
    }

    /**
     * returns the data from a given InputStream
     *
     * @param inputSream the InputStream to read from
     * @return the election results
     */
    public List<Film> getData(InputStream inputSream) {
        data = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(inputSream))) {
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
            // TODO: crash and burn
        }
        return data;

    }
}
