CREATE PROCEDURE GetNextSequenceValue\n       @sequenceName NVARCHAR(50),\n       @nextValue BIGINT OUTPUT\n   AS\n   BEGIN\n       UPDATE Sequences\n       SET @nextValue = CurrentValue + 1,\n           CurrentValue += 1\n       WHERE Name = @sequenceName;\n   END;