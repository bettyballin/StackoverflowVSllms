SELECT DISTINCT A.idA, A.Column1, A.Column2, ... -- include all columns that define uniquenss for TableA records\nFROM TableA A\nINNER JOIN TableB B ON A.idA = B.IdA\nWHERE B.Date = '2009-01-10'\nORDER BY A.idA;