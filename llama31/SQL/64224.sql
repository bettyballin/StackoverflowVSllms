SELECT o.newID\nFROM oriseqs o\nLEFT JOIN cleanreport c ON o.newID = c.newID AND c.trash != ""\nWHERE o.singlets = 1 AND c.newID IS NULL;