command.CommandText = "SELECT * FROM TableOfAwesomeness WHERE BestTVShow LIKE CONCAT(@tvShow, '%')"\ncommand.Parameters.Add("@tvShow", TVShow)