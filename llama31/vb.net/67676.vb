Dim db As DAO.Database\nDim rs As DAO.Recordset\n\nSet db = CurrentDb()\nSet rs = db.OpenRecordset("your_table")\n\nrs.AddNew\nrs!product_number = "26273B2"  ' modify the product number\nrs!test_results = rs!test_results  ' copy the test results\n'... copy other fields as needed\nrs.Update\n\nrs.Close\nSet rs = Nothing\nSet db = Nothing