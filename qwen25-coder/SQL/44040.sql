SELECT u.firstname, u.lastname\nFROM tbl_users u\nWHERE u.userID IN (\n    SELECT du.userID\n    FROM userDepartments du\n    GROUP BY du.userID\n    HAVING COUNT(du.userID) > 1\n);