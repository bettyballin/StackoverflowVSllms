SELECT GROUP_CONCAT(CONCAT(First_Name, ' ', Last_Name) SEPARATOR ', ') AS FullNameList\nFROM mytable;