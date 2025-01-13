UPDATE Tracking\nSET\nbookmark = (SELECT bookmark FROM Tracking AS t2 WHERE t2.courseID = Tracking.courseID - 5 AND t2.userID = Tracking.userID),\n...\nWHERE (courseID = 11 OR courseID = 6)\nAND userID IN (SELECT userID FROM Tracking WHERE courseID = Tracking.courseID - 5 AND complete = 1 AND complete_date >= '2008-08-01')