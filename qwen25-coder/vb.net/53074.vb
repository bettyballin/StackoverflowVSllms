Public Class CustomerDataAccessLayer\n    Private GlobalDataBase As Database\n\n    Public Sub New(database As Database)\n        Set GlobalDataBase = database\n    End Sub\n\n    Public Function GetCustomerByID(customerID As Integer) As Recordset\n        Dim strSQL As String\n        strSQL = "SELECT * FROM tblCustomers WHERE ID = " & customerID\n        Set GetCustomerByID = GlobalDataBase.OpenRecordset(strSQL)\n    End Function\nEnd Class