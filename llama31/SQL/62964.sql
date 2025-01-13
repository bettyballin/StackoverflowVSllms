SELECT t1.Date, t1.LocationID, t1.Account\nFROM your_table t1\nJOIN (\n  SELECT LocationID, MAX(Date) as MaxDate\n  FROM your_table\n  GROUP BY LocationID\n) t2\nON t1.LocationID = t2.LocationID AND t1.Date = t2.MaxDate