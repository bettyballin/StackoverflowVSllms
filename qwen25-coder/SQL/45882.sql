UPDATE #YourTempTable\nSET LatestDate = CASE \n                    WHEN DateColumn1 >= DateColumn2 AND DateColumn1 >= DateColumn3 THEN DateColumn1\n                    WHEN DateColumn2 >= DateColumn1 AND DateColumn2 >= DateColumn3 THEN DateColumn2\n                    ELSE DateColumn3\n                 END\nWHERE YourCondition;