Imports System.Net.Http\n\nFunction GetValueFromApi() As String\n    Dim result As String = ""\n    Dim url As String = "http://yourserver/YourHandlerName.ashx"\n\n    Using client As New HttpClient()\n        Try\n            ' Send a GET request to the ASHX handler.\n            Dim response As HttpResponseMessage = client.GetAsync(url).Result\n\n            If response.IsSuccessStatusCode Then\n                ' Read the content as string and assign it to the result variable.\n                result = response.Content.ReadAsStringAsync().Result\n            Else\n                ' Handle the error if something went wrong.\n                result = "Error: Failed to retrieve data"\n            End If\n        Catch ex As Exception\n            ' Log or handle the exception accordingly.\n            result = "Exception: " & ex.Message\n        End Try\n    End Using\n\n    Return result\nEnd Functio