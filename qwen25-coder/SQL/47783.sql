DECLARE @myvar INT;\nSET @myvar = 8;\n\nSELECT * \nFROM mytable \nWHERE id > @myvar;