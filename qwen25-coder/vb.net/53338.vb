Public Class Object1\n    Public Event MyEvent As EventHandler\n\n    ' A flag to check if Object2 is ready to handle events\n    Private m_Object2Ready As Boolean = False\n\n    Public Sub SetObject2Ready()\n        m_Object2Ready = True\n    End Sub\n\n    Public Sub RaiseMyEvent()\n        If m_Object2Ready AndAlso MyEvent IsNot Nothing Then\n            RaiseEvent MyEvent(Me, EventArgs.Empty)\n        End If\n    End Sub\nEnd Class\n\nPublic Class Object2\n    Public Sub New(ByVal obj1 As Object1)\n        AddHandler obj1.MyEvent, AddressOf Me.HandleMyEvent\n        ' Signal to Object1 that this instance is ready\n        obj1.SetObject2Ready()\n    End Sub\n\n    Private Sub HandleMyEvent(sender As Object, e As EventArgs)\n        ' Event handling code here\n    End Sub\nEnd Class