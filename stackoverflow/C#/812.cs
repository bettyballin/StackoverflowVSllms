// from user input\nstring user_column = "ItemID";\nstring user_value = "3";\n\nstring sql = "SELECT INVITEM.CharId AS CharId, INVITEM.ItemId AS ItemId FROM (INVITEM as INVITEM INNER JOIN SHOPITEM AS SHOPITEM ON SHOPITEM.ItemId = INVITEM.ItemId) ";\n\nif (user_column == "ItemID")\n{\n    // using Int32.Parse here to prevent rubbish like "0 OR 1=1; --" being entered.\n    sql += string.Format("WHERE INVITEM.ItemID={0}",Int32.Parse(user_value));\n}