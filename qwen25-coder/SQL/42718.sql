CREATE PROCEDURE InsertXMLData(@xmlData XML)\nAS\nBEGIN\n    -- Assuming a table named MyTable with columns Column1, Column2...\n    INSERT INTO MyTable (Column1, Column2, Column3)\n    SELECT \n        T.Item.value('(Field1/text())[1]', 'NVARCHAR(255)') AS Column1,\n        T.Item.value('(Field2/text())[1]', 'INT') AS Column2,\n        T.Item.value('(Field3/text())[1]', 'NVARCHAR(255)') AS Column3\n    FROM \n        @xmlData.nodes('/Root/Item') AS T(Item);\nEND;