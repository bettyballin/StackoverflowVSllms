Dim myDataTable As DataTable\nDim tmpStr As String\nDim sID As Integer = 1\n\n' ... \nmyDataTable = myTableAdapter.GetData() ' Reads the data from MS-Access table\n' ...\n\nFor Each myItem As DataRow In myDataTable.Rows\n\n    tmpStr = myItem("lastname").ToString() + " " + myItem("initials").ToString()\n\n    If Not IsDBNull(myItem("sID")) AndAlso Convert.ToInt32(myItem("sID")) = sID Then\n        ' Do something\n    End If\n\n    ' print tmpStr\n    Console.WriteLine(tmpStr)\n\nNext