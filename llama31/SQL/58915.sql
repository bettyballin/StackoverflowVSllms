SELECT \n  A, \n  First(B) & ',' & GroupBy(TBL.B, ',') AS B_values\nFROM \n  TBL\nGROUP BY \n  A;