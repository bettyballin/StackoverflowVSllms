SELECT element_id, \n           category, \n           source_prefix, \n           MAX(date_updated) AS last_date_updated,\n           AVG(value * weight) / SUM(weight) AS rating\n    FROM bigbigtable \n    WHERE date_updated <= '2009-04-28'\n    GROUP BY element_id, category, source_prefix;