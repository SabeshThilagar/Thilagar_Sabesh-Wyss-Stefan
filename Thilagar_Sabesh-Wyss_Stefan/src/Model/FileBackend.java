package Model;

import java.io.BufferedReader;
import java.io.File;
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
    private String fileName = "movies.txt";

    @Override
    public List<Film> getData() {
        return getData(getClass().getResourceAsStream(fileName));
    }

    @Override
    public void setFileName(String name) {
        File file = new File(name);
        if (file.exists()) {
            this.fileName = name;
        }
    }

    public List<Film> getData(String path) {
        try {
            return getData(new FileInputStream(path));
        } catch (FileNotFoundException exception) {
            System.out.println("keine Datei");
            System.out.println("File not found: " + exception.getMessage());
        }
        return null;
    }

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
            System.out.println("falsche Daten");
            System.out.println("General I/O exception: " + exception.getMessage());
        }
        return data;

    }

}
