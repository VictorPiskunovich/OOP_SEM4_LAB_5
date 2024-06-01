package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Movies
{
    private Database database;

    public static final String DB_URL = "jdbc:mysql://localhost:3306/movies";
    public static final String DB_LOGIN = "root";
    public static final String DB_PASSWORD = "root";

    public List<Movie> getMovies() throws SQLException
    {
        List<Movie> moviesList = new ArrayList<>();

        database = new Database(DB_URL, DB_LOGIN, DB_PASSWORD);

        ResultSet resultSet = database.executeQuery("SELECT id, name, director, year, fees, genre, budget FROM movies");
        while (resultSet.next())
        {
            moviesList.add(new Movie(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getInt(5),
                    resultSet.getString(6),
                    resultSet.getInt(7)
            ));
        }

        return moviesList;
    }

    public void addMovie(Movie movie) throws SQLException
    {
        database = new Database(DB_URL, DB_LOGIN, DB_PASSWORD);

        database.executeQuery(String.format("INSERT INTO movies (name, director, year, fees, genre, budget) " +
                        "VALUES ('%s', '%s', %d, %d, '%s', %d)",
                        movie.getName(), movie.getDirector(), movie.getYear(), movie.getFees(), movie.getGenre(), movie.getBudget()));

        database.closeConnection();
    }

    public void removeMovieById(int movieId) throws SQLException
    {
        database = new Database(DB_URL, DB_LOGIN, DB_PASSWORD);

        database.executeQuery(String.format("DELETE FROM movies WHERE id=%d", movieId));

        database.closeConnection();
    }

    public void updateMovieById(int movieId, Movie newMoive) throws SQLException
    {
        database = new Database(DB_URL, DB_LOGIN, DB_PASSWORD);

        database.executeQuery(String.format("UPDATE movies SET name='%s', director='%s', year=%d, fees=%d, genre='%s', budget=%d " +
                        "WHERE id=%d",
                newMoive.getName(), newMoive.getDirector(), newMoive.getYear(), newMoive.getFees(), newMoive.getGenre(), newMoive.getBudget(), movieId));

        database.closeConnection();
    }
}
