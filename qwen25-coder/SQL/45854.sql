INSERT INTO Conditions (ColumnName, Operator, Value1, Value2)\nVALUES ('value1', 'between', 20, 40);\n\nDECLARE @ConditionID INT;\nSET @ConditionID = SCOPE_IDENTITY();\n\nINSERT INTO Actions (ConditionID, Operation, TargetColumn, Multiplier)\nVALUES (@ConditionID, 'multiply', 'value2', 37.8);