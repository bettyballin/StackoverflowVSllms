SELECT *\nFROM (\n  SELECT \n    EXTRACT(WEEK FROM j.updated_at) as "week", \n    count(j.id)  \n  FROM  \n    jobs    \n  WHERE  \n    EXTRACT(YEAR FROM j.updated_at)=2009   \n  GROUP BY EXTRACT(WEEK FROM j.updated_at)  \n  ORDER BY week DESC\n  LIMIT 12\n) AS subquery\nORDER BY week ASC;