DECLARE @valueInt INT\nDECLARE @valueString NVARCHAR(100)\n\n-- Example usage\nIF ISNUMERIC(@valueString) = 1\nBEGIN\n    PRINT 'The value is numeric.'\n    -- Additional logic for numeric value\nEND\nELSE\nBEGIN\n    PRINT 'The value is not numeric.'\n    -- Additional logic for non-numeric value\nEND