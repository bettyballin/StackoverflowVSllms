Public Class SharedCounter\n    Public Shared counter As Integer = 0\n\n    Public Shared Sub Increment()\n        counter += 1\n    End Sub\nEnd Class\n\n' In your main application code:\nSub Main()\n    SharedCounter.Increment()\n    Console.WriteLine(SharedCounter.counter)\nEnd Sub