UPDATE t1 \nINNER JOIN TempTable \nON t1.PrimaryKey = TempTable.PrimaryKey\nSET t1.t2ID = TempTable.ID;