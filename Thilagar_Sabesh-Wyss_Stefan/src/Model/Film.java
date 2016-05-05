package Model;

public class Film {

    private final int id;
    private final int yearOfAward;
    private final String title;
    private final String director;
    private final String mainActor;
    private final String titleEnglish;
    private final int yearOfProduction;
    private final String country;
    private final int duration;
    private final int fsk;
    private final String genre;
    private final String startDate;
    private final int numberOfOscars;

    public Film(int id, String title,int yearOfAward,  String director, String mainActor, String titleEnglish, int yearOfProduction, String country, int duration, int fsk, String genre, String startDate, int numberOfOscars) {
        this.id = id;
        this.yearOfAward = yearOfAward;
        this.title = title;
        this.director = director;
        this.mainActor = mainActor;
        this.titleEnglish = titleEnglish;
        this.yearOfProduction = yearOfProduction;
        this.country = country;
        this.duration = duration;
        this.fsk = fsk;
        this.genre = genre;
        this.startDate = startDate;
        this.numberOfOscars = numberOfOscars;
    }

    public int getId() {
        return id;
    }

    public int getYearOfAward() {
        return yearOfAward;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getMainActor() {
        return mainActor;
    }

    public String getTitleEnglish() {
        return titleEnglish;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public String getCountry() {
        return country;
    }

    public int getDuration() {
        return duration;
    }

    public int getFsk() {
        return fsk;
    }

    public String getGenre() {
        return genre;
    }

    public String getStartDate() {
        return startDate;
    }

    public int getNumberOfOscars() {
        return numberOfOscars;
    }

}
