WITH subquery AS (\n    SELECT <Fields>\n    FROM <Multiple Tables Joined>\n)\nSELECT <Fields>\nFROM <Multiple Tables Joined>\nLEFT JOIN subquery ON <Condition>