<%@ page import="model.Movie" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Список фильмов</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <h2 style="margin-top: 20px; margin-bottom: 20px;">Список фильмов</h2>
    <table class="table">
        <thead>
            <tr>
                <th>Название</th>
                <th>Режиссёр</th>
                <th>Год выпуска</th>
                <th>Сборы ($)</th>
                <th>Жанр</th>
                <th>Бюджет ($)</th>
            </tr>
        </thead>
        <tbody>
            <% List<Movie> moviesList = (List<Movie>) request.getAttribute("moviesList");
                for (Movie Movie : moviesList) { %>
            <tr>
                <td><%= Movie.getName() %></td>
                <td><%= Movie.getDirector() %></td>
                <td><%= Movie.getYear() %></td>
                <td><%= Movie.getFees() %></td>
                <td><%= Movie.getGenre() %></td>
                <td><%= Movie.getBudget() %></td>
                <td><a href="edit?movieId=<%= Movie.getId() %>" class="btn btn-primary"><i class="fas fa-pencil-alt"></i></a></td>
                <td><a href="delete?movieId=<%= Movie.getId() %>" class="btn btn-outline-danger"><i class="fas fa-trash-alt"></i></a></td>
            </tr>
            <% } %>
        </tbody>
    </table>

    <hr style="margin-top: 60px;">

    <div class="container" style="margin-top: 60px; margin-bottom: 100px;">
      <h2>Добавить фильм</h2>
      <form action="addition" method="post" id="addition">
          <div class="form-row">
              <div class="form-group col-md-6">
                  <label for="name">Название:</label>
                  <input type="text" class="form-control" id="name" name="name" required>
              </div>
              <div class="form-group col-md-6">
                  <label for="director">Режиссёр:</label>
                  <input type="text" class="form-control" id="director" name="director" required>
              </div>
              <div class="form-group col-md-6">
                  <label for="year">Год выпуска:</label>
                  <input type="number" class="form-control" id="year" name="year" min="1901" max="2155" required>
              </div>
              <div class="form-group col-md-6">
                  <label for="fees">Сборы ($):</label>
                  <input type="number" class="form-control" id="fees" name="fees" min="0" required>
              </div>
              <div class="form-group col-md-6">
                  <label for="genre">Жанр:</label>
                  <input type="text" class="form-control" id="genre" name="genre" required>
              </div>
              <div class="form-group col-md-6">
                  <label for="budget">Бюджет ($):</label>
                  <input type="number" class="form-control" id="budget" name="budget" min="1" required>
              </div>
          </div>
          <button type="submit" class="btn btn-primary" id="add">Добавить</button>
      </form>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
