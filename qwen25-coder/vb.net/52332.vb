' Example of creating a connection with DAO (simplified)\nDim db As DAO.Database\nSet db = DBEngine(0).OpenDatabase("C:\Path\To\Database.accdb")\n\n' Example of creating a connection with ADO (simplified)\nDim conn As ADODB.Connection\nSet conn = New ADODB.Connection\nconn.Open "Provider=Microsoft.ACE.OLEDB.12.0;Data Source=C:\Path\To\Database.accdb;"