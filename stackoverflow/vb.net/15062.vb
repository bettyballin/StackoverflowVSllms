Dim sw As New Stopwatch()\nsw.Start()\n//Insert Code To Time\nsw.Stop()\nDim ms As Long = sw.ElapsedMilliseconds\nConsole.WriteLine("Total Seconds Elapsed: " & ms / 1000)