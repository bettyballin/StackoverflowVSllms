Imports System.Data.SqlClient\nImports Dapper\n\nPublic Function GetListDapper(Of T As New)(commandText As String, Optional parameters As Object = Nothing) As List(Of T)\n    Using connection As New SqlConnection("Your Connection String Here")\n        Return connection.Query(Of T)(commandText, param:=parameters).ToList()\n    End Using\nEnd Functio