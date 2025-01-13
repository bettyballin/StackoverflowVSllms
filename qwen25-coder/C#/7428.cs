using Google.Apis.Auth.OAuth2;\nusing Google.Apis.Drive.v3;\nusing Google.Apis.Services;\nusing System.Collections.Generic;\n\nclass Program {\n    static void Main(string[] args) {\n        var credential = GoogleWebAuthorizationBroker.AuthorizeAsync(\n            new ClientSecrets {\n                ClientId = "YOUR_CLIENT_ID",\n                ClientSecret = "YOUR_CLIENT_SECRET"\n            },\n            new[] { DriveService.Scope.DriveReadonly },\n            "user",\n            System.Threading.CancellationToken.None,\n            new FileDataStore("Drive.API.Store")).Result;\n\n        var service = new DriveService(new BaseClientService.Initializer() {\n            HttpClientInitializer = credential,\n            ApplicationName = "YOUR_APPLICATION_NAME",\n        });\n\n        FilesResource.ListRequest listRequest = service.Files.List();\n        listRequest.PageSize = 10;\n        listRequest.Fields = "nextPageToken, files(id, name)";\n\n        IList<Google.Apis.Drive.v3.Data.File> files = listRequest.Execute().Files;\n\n        if (files != null && files.Count > 0) {\n            foreach (var file in files) {\n                System.Console.WriteLine("{0} ({1})", file.Name, file.Id);\n            }\n        } else {\n            System.Console.WriteLine("No files found.");\n        }\n    }\n}