SELECT t, te \nFROM Test t \nLEFT JOIN t.testExtension te \nWHERE t.testId = :testId