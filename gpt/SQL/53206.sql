SELECT candidate.colour, \n       (SELECT AVG(apples+bananas+oranges+pears+peaches)\n        FROM baskets AS average\n        WHERE average.colour = candidate.colour) AS fruit\nFROM baskets AS candidate\nGROUP BY candidate.colour;