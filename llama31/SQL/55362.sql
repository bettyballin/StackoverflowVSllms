SELECT [...]\nFROM tbl_Base_Prices base\nLEFT JOIN tbl_Factors fact\n    ON base.iProduct_ID = fact.iProduct_ID\n    AND base.iPosition = fact.iPosition\n    AND base.nNoteRate = fact.nNoteRate\n[...]