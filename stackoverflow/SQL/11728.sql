SELECT TOP 1\n   tbl.Id --or count(*)\nFROM\n   grandchildtable tbl\n   INNER JOIN\n   anothertable ON ... = ...\nWHERE\n   tbl.xxx = ...