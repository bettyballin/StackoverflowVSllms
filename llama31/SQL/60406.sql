BEGIN TRANSACTION;\nUPDATE TargetTable SET Property = 'New Value' WHERE Id = 1;\nUPDATE TargetTable SET Property = 'New Value' WHERE Id = 2;\n...\nUPDATE TargetTable SET Property = 'New Value' WHERE Id = 10000;\nCOMMIT TRANSACTION;