DELETE FROM myOtherTable\nWHERE myTableId IN (SELECT id FROM myTable WHERE id = -1)