DECLARE @string VARCHAR(100)\nSET @string = 'sfdasadhfasjfdlsajflsadsadsdadsa'\n\nSELECT \n    LEN(@string) - LEN(REPLACE(@string, 'd', '')) AS NumberOfOccurrences;