UPDATE Table_Name\nJOIN (SELECT ID, SUM(S_val) AS sum_s_val FROM Table_Name GROUP BY ID) AS t2\nON Table_Name.ID = t2.ID\nSET Table_Name.PAR = t2.sum_s_val