Imports System.Net.Http\nImports System.Threading.Tasks\n\nModule Module1\n    Sub Main()\n        Dim realIp = GetPublicIP().Result\n        Console.WriteLine("Your public IP address is: " & realIp)\n    End Sub\n\n    Async Function GetPublicIP() As Task(Of String)\n        Using client As New HttpClient()\n            Dim response = Await client.GetStringAsync("https://api.ipify.org?format=text")\n            Return response\n        End Using\n    End Function\nEnd Module