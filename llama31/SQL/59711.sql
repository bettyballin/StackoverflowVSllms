INSERT INTO destination (A, B, C)\nSELECT a1, b1, c1\nFROM source\nEXCEPT\nSELECT A, B, C\nFROM destination;