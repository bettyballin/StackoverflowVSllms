CREATE PROCEDURE CopyNewVersion (IN oldID INT)\nBEGIN\n    DECLARE newID INT;\n\n    -- Copy the main record and get the new ID\n    CALL CopyNewMainRecord(oldID, newID);\n\n    -- Copy all SUB1 records from oldID to newID\n    CALL CopyNewSub1Records(oldID, newID);\n\n    -- Optionally, return the newID or other details if needed\n    SELECT * FROM MAIN WHERE ID = newID;\nEND;