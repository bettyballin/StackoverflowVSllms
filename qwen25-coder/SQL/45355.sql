SELECT \n    ID_STUDENT,\n    ID_CLASS,\n    GRADE,\n    @row_number:=IF(@current_class = ID_CLASS, @row_number + 1, 1) AS RANK,\n    @current_class:=ID_CLASS\nFROM \n    your_table_name,\n    (SELECT @row_number:=0, @current_class:=NULL) AS t\nORDER BY \n    ID_CLASS,\n    GRADE DESC;