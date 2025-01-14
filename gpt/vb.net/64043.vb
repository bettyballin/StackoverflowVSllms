Public Class Object1\n    ' Declare the event using EventHandler\n    Public Event MyEvent As EventHandler\n\n    ' Method to raise the event\n    Public Sub RaiseEvent()\n        RaiseEvent MyEvent(Me, EventArgs.Empty)\n    End Sub\nEnd Class\n\nPublic Class Object2\n    ' Event handler which handles MyEvent\n    Public Sub HandleMyEvent(sender As Object, e As EventArgs)\n        ' Event handling code here\n        Console.WriteLine("Event handled in Object2.")\n    End Sub\nEnd Class