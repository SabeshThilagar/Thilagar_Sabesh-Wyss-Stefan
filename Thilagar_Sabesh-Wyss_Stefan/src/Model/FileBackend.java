<<<<<<< HEAD
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


=======
package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Stefan
 */
public class FileBackend implements MainModel {

    private List<Film> data;
    private String fileName = "movies.csv"; //Standard-FILE

    private final List<Film> eData = new ArrayList<>();

    @Override
    public List<Film> getData() {
        URL url = this.getClass().getResource(fileName);
        
        System.out.println(url);
        if (url != null) {

            if (".txt".equals(url.toString().substring(url.toString().length() - 4))) {
                System.out.println("txt " + fileName);
                return getDataTXT(getClass().getResourceAsStream(fileName));
            } else if (".csv".equals(url.toString().substring(url.toString().length() - 4))) {
                System.out.println("csv " + fileName);
                        File fi = new File("");
        String pfadi = fi.getAbsolutePath();
        String csvFile = pfadi + "\\"+fileName;
                return getDataCSV(new File(csvFile));
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
    public void setFileName(String name
    ) {
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

    public List<Film> getDataCSV(File fn) {
        String zeile;
        String[] split = null;
        ArrayList list = new ArrayList();
        data = new ArrayList<>();

        try {
            FileReader fileR = new FileReader(fn);
            BufferedReader buff = new BufferedReader(fileR);
            while ((zeile = buff.readLine()) != null) {
                split = zeile.split(";");
                for (int i = 0; i < split.length; i++) {
                    //leere Zeilen ignorieren
                    if (!(split[i].equals(""))) //eventuelle Leerzeichen zwischen zwei ';' entfernen
                    //und Wert in Liste schreiben
                    {
                        list.add(split[i].trim());
                    }
                }
            }
        } catch (IOException exception) {
            System.out.println("falsche Daten" + fn);
            System.out.println("General I/O exception: " + exception.getMessage());
        }
        return data;
    }
}
>>>>>>> swyss/master
