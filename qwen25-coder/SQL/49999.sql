SELECT \n    Number,\n    CASE \n        WHEN Date1 >= Date2 AND Date1 >= Date3 THEN Date1\n        WHEN Date2 >= Date1 AND Date2 >= Date3 THEN Date2\n        ELSE Date3\n    END AS Most_Recent_Date,\n    Cost\nFROM \n    TableName;