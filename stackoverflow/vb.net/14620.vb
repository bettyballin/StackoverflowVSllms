Public Class NumericTextBox : Inherits TextBox\n\n    Protected Overrides Function IsInputChar(Byval charCode As Char) As Boolean\n        If (Char.IsControl(charCode) Or Char.IsDigit(charCode)) Then\n            Return MyBase.IsInputChar(charCode)\n        Else\n            Return False\n        End If\n    End Function\n\nEnd Class