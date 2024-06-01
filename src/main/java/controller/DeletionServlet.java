package controller;

import model.Movie;
import model.Movies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/delete"})
public class DeletionServlet extends HttpServlet
{
    private final Movies movies = new Movies();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        int movieId = Integer.parseInt(req.getParameter("movieId"));

        try
        {
            movies.removeMovieById(movieId);

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
