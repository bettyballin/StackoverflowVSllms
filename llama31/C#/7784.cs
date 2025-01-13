void ahwebclient_UploadFileCompleted(object sender, System.Net.UploadFileCompletedEventArgs e)\n{\n    if (e.Error != null)\n    {\n        // handle error\n        Console.WriteLine("Upload failed: " + e.Error.Message);\n    }\n    else\n    {\n        string serverResponse = e.Result;\n        Console.WriteLine("Server response: " + serverResponse);\n    }\n}