DECLARE @Counter INT = 0;\n\nINSERT INTO TableB (ID, Names, Address)\nSELECT \n    (@Counter := @Counter + 1) AS ID, \n    Names, \n    Address \nFROM \n    TableA;