var results = dataContext.MyStoredProcedure(123).GetResult<MyCustomResult>();\nvar query = from r in results\n            where r.MyColumn1.StartsWith("abc")\n            select r;