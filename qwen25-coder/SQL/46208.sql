SELECT subject, MIN(yr) AS first_year\nFROM nobel\nGROUP BY subject;