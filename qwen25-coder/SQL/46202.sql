WHERE (Column1 = @Param1 OR Column1 LIKE @Param1 + '%')\nAND (@Param2 = '' OR Column2 = @Param2 OR Column2 LIKE @Param2 + '%')