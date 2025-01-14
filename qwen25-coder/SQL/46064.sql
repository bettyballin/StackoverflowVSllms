SELECT \n    t1.user_id,\n    t1.name AS user_name,\n    MAX(CASE WHEN DATEPART(MONTH, t2.date) = 10 AND YEAR(t2.date) = 2008 THEN t2.incident_code END) AS [INCIDENT IN OCT 2008],\n    MAX(CASE WHEN DATEPART(MONTH, t2.date) = 11 AND YEAR(t2.date) = 2008 THEN t2.incident_code END) AS [INCIDENT IN NOV 2008]\nFROM \n    Table1 t1\nJOIN \n    Table2 t2 ON t1.user_id = t2.user_id\nGROUP BY \n    t1.user_id, t1.name;