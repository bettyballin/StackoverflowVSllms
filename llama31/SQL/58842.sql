SELECT * \nFROM SomeTable \nWHERE SomeColumn='SomeCondition' AND \n      RAND(CHECKSUM(NEWID())) < 0.10