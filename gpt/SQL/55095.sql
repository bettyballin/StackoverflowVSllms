SELECT dbo.uf_AlphaNumericIncrement('A000299'); -- Returns 'A000300'\nSELECT dbo.uf_AlphaNumericIncrement('B001000'); -- Returns 'B001001'\nSELECT dbo.uf_AlphaNumericIncrement('XYZ100');  -- Returns 'XYZ101'\nSELECT dbo.uf_AlphaNumericIncrement('000099');  -- Returns '000100'\nSELECT dbo.uf_AlphaNumericIncrement('999');     -- Returns '1000'