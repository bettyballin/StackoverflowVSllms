SELECT f.title\nFROM Films f INNER JOIN\n    FREETEXTTABLE(Films, Title, @partialKeywordString LANGUAGE N'English') f_key ON f.filmid = f_key.[key]\nORDER BY f_key.Rank DESC