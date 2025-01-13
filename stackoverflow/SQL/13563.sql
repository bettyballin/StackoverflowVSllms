SELECT  du.userID, unit.answer, demo.answer\nFROM    (\n        SELECT  DISTINCT userID\n        FROM    table1\n        WHERE   date > '1/1/2009'\n        ) du\nLEFT JOIN\n        table2 unit\nON      (userID, question, counter) IN\n        (\n        SELECT  du.userID, 'Unit', MAX(counter)\n        FROM    table2 td\n        WHERE   userID = du.userID\n                AND question = 'Unit'\n        )\nLEFT JOIN\n        table2 demo\nON      (userID, question, counter) IN\n        (\n        SELECT  du.userID, 'Demo', MAX(counter)\n        FROM    table2 td\n        WHERE   userID = du.userID\n                AND question = 'Demo'\n        )