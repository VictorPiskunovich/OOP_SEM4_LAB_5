package model;

public class Movie
{
    private int id;
    private String name;
    private String director;
    private int year;
    private int fees;
    private String genre;
    private int budget;

    public Movie(int id, String name, String director, int year, int fees, String genre, int budget)
    {
        this.id = id;
        this.name = name;
        this.director = director;
        this.year = year;
        this.fees = fees;
        this.genre = genre;
        this.budget = budget;
    }

    public Movie(String name, String director, int year, int fees, String genre, int budget)
    {
        this(-1, name, director, year, fees, genre, budget);
    }


    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getDirector()
    {
        return director;
    }

    public int getYear()
    {
        return year;
    }

    public int getFees()
    {
        return fees;
    }

    public String getGenre()
    {
        return genre;
    }

    public int getBudget()
    {
        return budget;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (id != movie.id) return false;
        if (year != movie.year) return false;
        if (fees != movie.fees) return false;
        if (budget != movie.budget) return false;
        if (!name.equals(movie.name)) return false;
        if (!director.equals(movie.director)) return false;
        return genre.equals(movie.genre);
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + director.hashCode();
        result = 31 * result + year;
        result = 31 * result + fees;
        result = 31 * result + genre.hashCode();
        result = 31 * result + budget;
        return result;
    }
}
