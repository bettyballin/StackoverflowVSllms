SELECT StudentName, \n       MAX(CASE WHEN AssignmentName = 'Assignment 1' THEN Grade END) AS Assignment1,\n       MAX(CASE WHEN AssignmentName = 'Assignment 2' THEN Grade END) AS Assignment2,\n       MAX(CASE WHEN AssignmentName = 'Assignment 3' THEN Grade END) AS Assignment3,\n       SUM(CASE WHEN AssignmentName = 'Total' THEN Grade END) AS Total\nFROM YourTable\nGROUP BY StudentName