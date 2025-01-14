SELECT \n    courses.CourseID,\n    SUM(IF(sessions.Duration IS NULL, 0, sessions.Duration)) AS Hrs\nFROM \n    courses\nLEFT JOIN \n    sessions ON courses.CourseID = sessions.CourseID\n    AND (sessions.SessionDate >= '2009-06-01' AND sessions.SessionDate <= '2009-06-30')\nWHERE \n    courses.TrainerID = 113\nGROUP BY \n    courses.CourseID;