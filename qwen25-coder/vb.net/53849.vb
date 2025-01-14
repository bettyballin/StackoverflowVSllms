Imports SharpBits.Base\n\nModule Module1\n    Sub Main()\n        ' Create a BitsManager instance\n        Dim b As New BitsManager()\n\n        ' Create a new download job\n        Dim myNewJob As BitsJob = b.CreateJob("MyDownloadJob", JobType.Download)\n\n        Try\n            ' Add the file to be downloaded\n            myNewJob.AddFile("\\server\share\bigfile.zip", "c:\bigfile.zip")\n\n            ' Start the transfer\n            myNewJob.Resume()\n\n            ' Monitor job status\n            While Not (myNewJob.TransferState = TransferState.Transferred OrElse myNewJob.TransferState = TransferState.Error)\n                Console.WriteLine(String.Format("Transfer Status: {0}, Progress: {1}/{2} bytes, Speed: {3} bytes/sec",\n                                              myNewJob.TransferState,\n                                              myNewJob.BytesTransferred,\n                                              myNewJob.BytesTotal,\n                                              myNewJob.CurrentSpeed))\n                Threading.Thread.Sleep(5000)  ' Wait for 5 seconds\n            End While\n\n            If myNewJob.TransferState = TransferState.Transferred Then\n                Console.WriteLine("Download completed successfully.")\n            Else\n                Console.WriteLine("An error occurred during the download: " & myNewJob.ErrorDescription)\n            End If\n\n        Catch ex As Exception\n            Console.WriteLine("An exception was caught: " & ex.Message)\n        Finally\n            ' Clean up if necessary\n            b.Dispose()\n        End Try\n\n        Console.ReadLine()\n    End Sub\nEnd Module