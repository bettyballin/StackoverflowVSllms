Public Class ValidationResult\n    Public Property IsValid As Boolean\n    Public Property ErrorMessage As String\nEnd Class\n\nFriend Class CustomerValidation\n    Public Shared Function ValidateForCreate(cust As Customer) As ValidationResult\n        Dim result As New ValidationResult()\n        If cust.Name.Length > 50 Then ' Assuming varchar(50) in the database\n            result.IsValid = False\n            result.ErrorMessage = "Customer name exceeds the maximum allowed length."\n        Else\n            result.IsValid = True\n        End If\n        Return result\n    End Function\nEnd Class