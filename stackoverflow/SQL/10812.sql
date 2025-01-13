SELECT DISTINCT a.[Referral ID], b.CountOfADate, c.CountOfATeam, d.CountOfService, e.CountOfSTeam\n\nFROM (((imp AS a \n\nINNER JOIN \n    (SELECT b1.[Referral ID], Count(b1.ADate) AS CountOfADate\n     FROM (SELECT DISTINCT t.[Referral ID], t.[Assessment Date] As ADate FROM imp As t) AS b1\n     GROUP BY b1.[Referral ID]) AS b \nON a.[Referral ID] = b.[Referral ID]) \n\nINNER JOIN \n    (SELECT c1.[Referral ID], Count(c1.ATeam) AS CountOfATeam\n    FROM (SELECT DISTINCT t.[Referral ID], t.[Assessment Team] As ATeam FROM imp As t) AS c1\n    GROUP BY c1.[Referral ID]) AS c \nON a.[Referral ID] = c.[Referral ID]) \n\nINNER JOIN \n    (SELECT d1.[Referral ID], Count(d1.Service) AS CountOfService\n    FROM (SELECT DISTINCT t.[Referral ID], t.[Service Provided] As Service FROM imp As t) AS d1\n    GROUP BY d1.[Referral ID]) AS d \nON a.[Referral ID] = d.[Referral ID]) \n\nINNER JOIN \n    (SELECT e1.[Referral ID], Count(e1.STeam) AS CountOfSTeam\n    FROM (SELECT DISTINCT t.[Referral ID], t.[Service Team] As STeam FROM imp As t) AS e1\n    GROUP BY e1.[Referral ID]) AS e \nON a.[Referral ID] = e.[Referral ID];