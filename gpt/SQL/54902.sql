SET group_concat_max_len = 16000000;\nUPDATE Threads t \nSET t.Content = (\n    SELECT GROUP_CONCAT(a.Content ORDER BY a.PageID SEPARATOR '<!-- pagebreak -->') \n    FROM MSarticlepages a \n    WHERE a.ArticleID = t.MSthreadID \n    GROUP BY a.ArticleID\n);