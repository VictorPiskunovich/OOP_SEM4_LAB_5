package controller;

import model.Movie;
import model.Movies;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/addition"})
public class AdditionServlet extends HttpServlet
{
    private final Movies movies = new Movies();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String director = req.getParameter("director");
        int year = Integer.parseInt(req.getParameter("year"));
        int fees = Integer.parseInt(req.getParameter("fees"));
        String genre = req.getParameter("genre");
        int budget = Integer.parseInt(req.getParameter("budget"));

        Movie newMovie = new Movie(name, director, year, fees, genre, budget);

        try
        {
            movies.addMovie(newMovie);

            updatePage(req, resp);
        }
        catch (SQLException e)
        {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Ошибка базы данных: " + e.getMessage());
        }
    }

    private void updatePage(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException
    {
        List<Movie> moviesList = movies.getMovies();
        req.setAttribute("moviesList", moviesList);

        req.getRequestDispatcher("view/index.jsp").forward(req, resp);
    }
}
