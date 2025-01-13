SELECT SUM(MIN(fp-20, ap)) FROM\n  (SELECT dates.pk AS fd, SUM(points) AS fp\n  FROM dates\n  JOIN foods ON name_id = fd\n  GROUP BY fd\n  HAVING fp >= 20)\n    JOIN\n  (SELECT dates.pk AS ad, SUM(activity) AS ap\n  FROM dates\n  JOIN activities ON activity_id = ad\n  GROUP BY ad)\n    ON fd = ad