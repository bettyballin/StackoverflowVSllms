SELECT   [Last Name], [First Name], [Renewal Date]\nFROM     Members\nWHERE    ([Renewal Date] >= @fromDate) AND ([Renewal Date] <= @toDate)\nORDER BY [Renewal Date]