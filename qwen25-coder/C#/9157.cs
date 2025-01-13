private uint downloadImage(IntPtr directoryItem)\n{\n    uint err = EDSDK.EDS_ERR_OK;\n    IntPtr stream = IntPtr.Zero;\n\n    // Get information of the directory item.\n    EDSDK.EdsDirectoryItemInfo dirItemInfo;\n    err = EDSDK.EdsGetDirectoryItemInfo(directoryItem, out dirItemInfo);\n\n    // Create a memory stream for receiving image.\n    if (err == EDSDK.EDS_ERR_OK)\n    {\n        err = EDSDK.EdsCreateMemoryStream(dirItemInfo.Size, out stream);\n    }\n\n    // Fill the stream with the resulting image\n    if (err == EDSDK.EDS_ERR_OK)\n    {\n        err = EDSDK.EdsDownload(directoryItem, dirItemInfo.Size, stream);\n    }\n\n    // Copy the memory stream data to a byte[]\n    if (err == EDSDK.EDS_ERR_OK)\n    {\n        IntPtr dataPointer;\n        err = EDSDK.EdsGetPointer(stream, out dataPointer);\n        if (err == EDSDK.EDS_ERR_OK)\n        {\n            byte[] buffer = new byte[dirItemInfo.Size];\n\n            Marshal.Copy(dataPointer, buffer, 0, (int)dirItemInfo.Size);\n\n            // Image manipulation, show user, whatever\n        }\n    }\n\n    // Release the stream when done to avoid memory leaks\n    if (stream != IntPtr.Zero)\n    {\n        EDSDK.EdsRelease(stream);\n    }\n\n    return err;\n}