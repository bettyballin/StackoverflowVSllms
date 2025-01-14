Imports System\nImports System.Runtime.InteropServices\nImports BackgroundCopyManager\n\nModule Module1\n\n    Sub Main()\n        Dim manager As New BackgroundCopyManager()\n        Dim job As IBackgroundCopyJob\n        manager.CreateJob("My BITS Job", BG_JOB_TYPE.BG_JOB_TYPE_DOWNLOAD, job)\n        \n        ' Add the file to download\n        job.AddFile("\\server\share\file.txt", "C:\path\to\download\file.txt")\n        \n        ' Resume the job\n        job.Resume()\n        \n        ' Optionally, you can check the status of the job\n        Dim state As BG_JOB_STATE\n        job.GetState(state)\n        Console.WriteLine($"Job State: {state}")\n        \n        ' Complete the job\n        job.Complete()\n        \n        Console.WriteLine("File download complete.")\n    End Sub\nEnd Module