Imports System.Diagnostics\nImports System.Threading\n\nSub Main()\n    Using setupProcess As New Process()\n        setupProcess.StartInfo.FileName = "setup.exe"\n        setupProcess.StartInfo.WindowStyle = ProcessWindowStyle.Normal\n        setupProcess.Start()\n        \n        ' Wait for setup.exe to exit\n        setupProcess.WaitForExit()\n\n        ' Optional: Add a small delay to ensure msiexec starts\n        Thread.Sleep(1000)\n\n        ' Get the list of msiexec processes\n        Dim msiexecProcesses = Process.GetProcessesByName("msiexec")\n\n        ' Wait for all msiexec processes to exit\n        For Each msiexecProcess As Process In msiexecProcesses\n            msiexecProcess.WaitForExit()\n        Next\n    End Using\n\n    ' Launch next setup here\n    Using nextSetupProcess As New Process()\n        nextSetupProcess.StartInfo.FileName = "nextSetup.exe"\n        nextSetupProcess.StartInfo.WindowStyle = ProcessWindowStyle.Normal\n        nextSetupProcess.Start()\n    End Using\nEnd Sub