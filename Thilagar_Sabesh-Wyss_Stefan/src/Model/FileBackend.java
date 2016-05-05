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
        return getData(getClass().getResourceAsStream("movies.csv"));
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
 
//        try (BufferedReader bufferedReader = new BufferedReader(
//                new InputStreamReader(inputSream))) {
//            bufferedReader.lines().skip(1).forEach(e -> {
//                String[] col = e.split(",");
//               data.add(new Film(
//                        Integer.parseInt(col[0]),
//                        Integer.parseInt(col[1]),
//                        col[2],
//                        col[3],
//                        col[4],
//                        col[5],
//                        Integer.parseInt(col[6]),
//                        col[7],
//                        Integer.parseInt(col[8]),
//                        Integer.parseInt(col[9]),
//                        col[10],
//                        col[11],
//                        Integer.parseInt(col[12])));

        } catch (IOException exception) {
            // TODO: crash and burn
        }
        return data;
    }
}


