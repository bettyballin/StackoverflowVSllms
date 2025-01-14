Imports System.Net.Http\nImports System.Threading.Tasks\n\nPrivate Async Function MakeRequestAsync() As Task\n    Using client As New HttpClient()\n        Dim response As HttpResponseMessage = Await client.GetAsync("http://foo.com/bar")\n\n        If response.IsSuccessStatusCode Then\n            Dim content As String = Await response.Content.ReadAsStringAsync()\n            ' Process the content here.\n        End If\n    End Using\nEnd Functio