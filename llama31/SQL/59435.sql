SELECT \n    T1.theField, \n    COUNT(T2.someField) / (SELECT COUNT(someField) FROM table1 WHERE someField = T1.theField)\nFROM \n    (SELECT someField AS theField FROM table1) T1 \n    LEFT JOIN table2 T2 ON T1.theField = T2.someField\nGROUP BY \n    T1.theField