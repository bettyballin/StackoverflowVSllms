SELECT \n    f.title,\n    (CASE \n        WHEN CONTAINS(f.Title, @exactKeywordString) THEN 10\n        ELSE 0\n     END + f_key.Rank) AS WeightedRank\nFROM \n    Films f \nINNER JOIN\n    CONTAINSTABLE(Films, Title, @partialKeywordString) f_key ON f.filmid = f_key.[key]\nORDER BY \n    WeightedRank DESC;