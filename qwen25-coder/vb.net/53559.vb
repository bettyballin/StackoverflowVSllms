Dim db As DAO.Database\nSet db = CurrentDb\n\nDim qdf As DAO.QueryDef\nSet qdf = db.CreateQueryDef("", "UPDATE tbltesting SET IsDiff = 'Yes' WHERE empid= [pEmpId] AND testid = [pTestId]")\nqdf.Parameters("pEmpId") = Me.txtEmpId.Value\nqdf.Parameters("pTestId") = Me.txtAutoNumber.Value\n\nqdf.Execute dbFailOnError\nSet qdf = Nothing