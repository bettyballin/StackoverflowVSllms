DECLARE @string VARCHAR(100)\nSELECT @string = 'sfdasadhfasjfdlsajflsadsadsdadsa'\nSELECT LEN(@string) - LEN(REPLACE(@string, 'd', '')) AS CountOfD