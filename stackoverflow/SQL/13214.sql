select employeeid, count(*) \nfrom dbo.EmpDept \ngroup by employeeid \nhaving count(*) > 1;