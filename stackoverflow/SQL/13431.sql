SELECT *\nFROM Employees_List\n   INNER JOIN \n       (Media_List INNER JOIN Distance_List ON Media_List.Zip = Distance_List.Target_Zip)\n   ON Employees_List.Zip = Distance_List.Source_Zip\nWHERE distance_Miles <=5