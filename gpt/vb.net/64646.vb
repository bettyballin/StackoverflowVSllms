Try\n    ObjRapi.Connect()\n    \n    ' Check if the connection is established\n    If ObjRapi.DevicePresent Then\n        ' Ensure the destination path is correct and accessible\n        Dim destFilePath As String = "\results.txt"\n        \n        ' Copy the file to the device\n        ObjRapi.CopyFileToDevice("C:\results.txt", destFilePath)\n    Else\n        Throw New Exception("Device not connected.")\n    End If\n\nCatch ex As Exception\n    ' Handle any errors that occur during the process\n    Console.WriteLine("An error occurred: " & ex.Message)\nFinally\n    ' Ensure resources are properly disposed and connection is closed\n    ObjRapi.Dispose()\n    ObjRapi.Disconnect()\nEnd Try