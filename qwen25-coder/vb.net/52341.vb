Imports System\n\nPublic Module NullChecker\n    Public Function IsNull(value As Object) As Boolean\n        Return value Is Nothing OrElse (Type.GetTypeCode(Type.GetTypeFromHandle(Type.GetTypeHandle(value))) <> TypeCode.Object AndAlso value.Equals(Convert.DBNull))\n    End Function\nEnd Module