Public Class B\n    Inherits Player\n\n    Dim desiredPower As Integer = 100\n\n    Public Overrides ReadOnly Property GetPower() As Integer\n        Get\n            Return desiredPower\n        End Get\n    End Property\n\n    Public Sub New()\n        InitializePower()\n    End Sub\nEnd Class