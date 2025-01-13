IF EXISTS (SELECT name FROM sys.objects\n      WHERE name = 'reminder' AND type = 'TR')\n   DROP TRIGGER Person.reminder;\nGO\nCREATE TRIGGER reminder\nON Person.Address\nAFTER UPDATE \nAS \nIF ( UPDATE (StateProvinceID) OR UPDATE (PostalCode) )\nBEGIN\nRAISERROR (50009, 16, 10)\nEND;\nGO\n-- Test the trigger.\nUPDATE Person.Address\nSET PostalCode = 99999\nWHERE PostalCode = '12345';\nGO