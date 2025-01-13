public void UploadFileToNetworkShare(string localFilePath, string networkPath)\n{\n    try\n    {\n        // Copy the file to the network share location\n        File.Copy(localFilePath, networkPath + Path.GetFileName(localFilePath), true);\n    }\n    catch (Exception ex)\n    {\n        Console.WriteLine("Error uploading file: " + ex.Message);\n    }\n}\n\npublic void DownloadFileFromNetworkShare(string remoteFilePath, string localPath)\n{\n    try\n    {\n        // Copy the file from the network share location to local path\n        File.Copy(remoteFilePath, localPath + Path.GetFileName(remoteFilePath), true);\n    }\n    catch (Exception ex)\n    {\n        Console.WriteLine("Error downloading file: " + ex.Message);\n    }\n}