SELECT \n    q1.[Referral ID], \n    q1.[Number of Assessments], \n    q2.[Teams Assessing], \n    q3.[Services Provided], \n    q4.[No Teams Providing]\nFROM \n    (SELECT [Referral ID], COUNT(DISTINCT [Assessment Date]) AS [Number of Assessments]\n     FROM [YourTable]\n     GROUP BY [Referral ID]) AS q1\nINNER JOIN \n    (SELECT [Referral ID], COUNT(DISTINCT [Assessment Team]) AS [Teams Assessing]\n     FROM [YourTable]\n     GROUP BY [Referral ID]) AS q2 ON q1.[Referral ID] = q2.[Referral ID]\nINNER JOIN \n    (SELECT [Referral ID], COUNT(DISTINCT [Service Provided]) AS [Services Provided]\n     FROM [YourTable]\n     GROUP BY [Referral ID]) AS q3 ON q1.[Referral ID] = q3.[Referral ID]\nINNER JOIN \n    (SELECT [Referral ID], COUNT(DISTINCT [Service Team]) AS [No Teams Providing]\n     FROM [YourTable]\n     GROUP BY [Referral ID]) AS q4 ON q1.[Referral ID] = q4.[Referral ID];