Imports System.Net.Http\n\nModule Module1\n    Sub Main()\n        Dim client As New HttpClient()\n        Dim responseTask = client.GetAsync("http://localhost:8080/hello")\n        Dim result = responseTask.Result.Content.ReadAsStringAsync().Result\n        Console.WriteLine(result)\n    End Sub\nEnd Module