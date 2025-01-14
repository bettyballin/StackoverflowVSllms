$this_week_start = date('Y-m-d H:i:s', $this_week_start);\n\n$query = "\n    SELECT \n        a.story_id, a.story_title, \n        SUM(CASE WHEN v.vote_code = 1 THEN 1 ELSE 0 END) AS num_yes_votes,\n        SUM(CASE WHEN v.vote_code = 0 THEN 1 ELSE 0 END) AS num_no_votes\n    FROM articles a\n    LEFT JOIN votes v ON a.story_id = v.vote_storyid\n    WHERE v.vote_date >= '$this_week_start'\n    GROUP BY a.story_id\n    ORDER BY num_yes_votes DESC\n";\n$result = mysqli_query($connection, $query);