-- Injecting a UNION SELECT statement (hypothetical example)\n' UNION SELECT 'attackValue1', 'attackValue2' -- '\n\n-- The sanitized version would become:\n'' UNION SELECT ''attackValue1'', ''attackValue2'' -- ''