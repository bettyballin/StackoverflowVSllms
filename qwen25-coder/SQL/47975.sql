SELECT * \nFROM Users\nWHERE IsAdmin = 1 AND @CurrentUserIsAdmin = 1;