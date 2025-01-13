Imports System.Security.Cryptography\n\nPublic Function HashPassword(password As String) As String\n    Dim salt As Byte() = New Byte(15) {}\n    Using rng As New RNGCryptoServiceProvider()\n        rng.GetBytes(salt)\n    End Using\n\n    Using pbkdf2 As New Rfc2898DeriveBytes(password, salt, 100000)\n        Dim hash As Byte() = pbkdf2.GetBytes(20)\n        Dim hashBytes As Byte() = New Byte(35) {}\n        Array.Copy(salt, 0, hashBytes, 0, 16)\n        Array.Copy(hash, 0, hashBytes, 16, 20)\n        Return Convert.ToBase64String(hashBytes)\n    End Using\nEnd Function\n\nPublic Function VerifyPassword(password As String, hashedPassword As String) As Boolean\n    Dim hashBytes As Byte() = Convert.FromBase64String(hashedPassword)\n    Dim salt As Byte() = New Byte(15) {}\n    Array.Copy(hashBytes, 0, salt, 0, 16)\n\n    Using pbkdf2 As New Rfc2898DeriveBytes(password, salt, 100000)\n        Dim hash As Byte() = pbkdf2.GetBytes(20)\n        For i As Integer = 0 To 19\n            If hashBytes(i + 16) <> hash(i) Then\n                Return False\n            End If\n        Next\n    End Using\n\n    Return True\nEnd Functio