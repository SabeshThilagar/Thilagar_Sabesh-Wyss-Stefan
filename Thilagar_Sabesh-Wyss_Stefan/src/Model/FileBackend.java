
/*
$FHNW
 */
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

//    public FileBackend() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public List<Film> getData(String path) {
        try {
            return getData(new FileInputStream(path));
        } catch (FileNotFoundException ex) {
            // TODO
        }
        return null;
    }

    public List<Film> getData(InputStream inputSream) {
        data = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(inputSream))) {
//            bufferedReader.lines().skip(1).forEach((String e) -> {
//                String[] tokens = e.split("\t");
//                data.add(new Film(
//                        tokens[1],
//                        tokens[2],
//                        Integer.parseInt(tokens[20]),
//                        Integer.parseInt(tokens[21])));
//            });
        } catch (IOException exception) {
            // TODO: crash and burn
        }
        return data;
    }

    @Override
    public List<Film> getData() {
        return getData(getClass().getResourceAsStream("movies.csv"));
    }


}
