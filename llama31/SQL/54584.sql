SELECT *\nFROM PERSON\nORDER BY\n  CASE :1\n    WHEN 'NAME' THEN NAME\n    WHEN 'AGE' THEN AGE\n    -- add more cases as needed\n    ELSE NULL\n  END;