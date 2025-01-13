Public Shared Function GetExcelVersion() As Integer\n    Dim excel As Object = Nothing\n    Dim ver As Integer = 0\n    Dim build As Integer\n    Try\n        excel = CreateObject("Excel.Application")\n        ver = excel.Version\n        build = excel.Build\n    Catch ex As Exception\n        'Continue to finally sttmt\n    Finally\n        Try\n            Marshal.ReleaseComObject(excel)\n        Catch\n        End Try\n        GC.Collect()\n    End Try\n    Return ver\nEnd Functio