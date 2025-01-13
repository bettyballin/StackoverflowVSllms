WITH last_day_of_month AS (\n  SELECT TRUNC(daterange, 'MM') - 1 AS first_of_month,\n         MAX(TRUNC(daterange)) AS last_day_with_data\n  FROM (\n    SELECT TRUNC(sysdate - 365, 'MM') + LEVEL AS DateRange\n    FROM dual\n    CONNECT BY LEVEL <= 365\n  )\n  GROUP BY TRUNC(daterange, 'MM')\n)\nSELECT fd.cust_id,\n       fd.server_name,\n       fd.instance_name,\n       TRUNC(fd.coll_date) AS coll_date,\n       fd.column_name\nFROM super_table fd\nJOIN last_day_of_month ldom\n  ON TRUNC(fd.coll_date) = ldom.last_day_with_data\n  AND fd.cust_id = :CUST_ID\n  AND fd.coll_date > SYSDATE - 400\nGROUP BY fd.cust_id,\n         fd.server_name,\n         fd.instance_name,\n         TRUNC(fd.coll_date),\n         fd.column_name\nORDER BY fd.server_name,\n         fd.instance_name,\n         TRUNC(fd.coll_date);