-- Suppose the user parameter is stored in a variable @user_param\nSET @user_param = 1;\n\nSELECT position, name\nFROM items\nORDER BY \n  CASE \n    WHEN @user_param = 0 THEN position\n    WHEN @user_param = 1 THEN FIELD(position, 20, 1, 5, 8, 9, 15)\n    WHEN @user_param = 2 THEN FIELD(position, 15, 20, 1, 5, 8, 9)\n    -- Add more conditions as needed\n    ELSE position\n  END;