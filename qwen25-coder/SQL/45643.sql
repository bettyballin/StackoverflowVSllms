SELECT *\nFROM cool_table \nWHERE date >= TO_DATE('200901010000', 'YYYYMMDDhh24mi')\nORDER BY seq_nr, entry_dts\nOFFSET 50 ROWS FETCH NEXT 50 ROWS ONLY;