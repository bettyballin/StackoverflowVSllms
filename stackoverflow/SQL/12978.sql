ALTER FUNCTION dbo.ufnRound (@number money)\nRETURNS money\nAS\nBEGIN\n    RETURN FLOOR(@number*20) / 20\nEND\nGO\nSELECT dbo.ufnRound (1.22), dbo.ufnRound (1.23), dbo.ufnRound (1.27), dbo.ufnRound (1.28)\n\n-- gives    1.2    1.2   1.25   1.25