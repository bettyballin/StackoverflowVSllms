-- Efficient for List method\nSELECT Id, DisplayColumn\nFROM Person\nWHERE PersonName LIKE '%frank%';\n\n-- Simple but potentially less efficient but easier to maintain for Select and Search methods\nSELECT *\nFROM Person\nWHERE PersonName LIKE '%frank%';