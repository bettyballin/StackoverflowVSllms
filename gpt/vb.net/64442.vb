Imports System\n\nModule Module1\n    Sub Main()\n        Try\n            Dim todayDate As DateTime = DateTime.Now.Date\n            Console.WriteLine("Today's date is: " & todayDate.ToString("d"))\n        Catch ex As Exception\n            Console.WriteLine("An error occurred: " & ex.Message)\n        End Try\n    End Sub\nEnd Module