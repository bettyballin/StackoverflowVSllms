Imports Microsoft.SqlServer.Dts.Runtime\nImports SQLDTSRun\n\nPublic Class Form1\n    Private Sub ExecuteDTSPackage()\n        Dim dtsApplication As New SQLDTSRun.ApplicationClass()\n        Try\n            ' Execute the DTS package using its Global Unique Identifier (GUID)\n            Dim packageID As String = "PUT_YOUR_DTS_PACKAGE_GUID_HERE"\n            Dim serverName As String = "YOUR_SERVER_NAME"\n            Dim packageName As String = "YOUR_PACKAGE_NAME"\n\n            Dim executionResult As DTReturnCode\n            executionResult = dtsApplication.RunPackage("{DTS:" & packageID & "}", SQLServerName:=serverName, SQLUseTrustedConnection:=True)\n\n            If (executionResult >= DTReturnCode.Success) Then\n                MessageBox.Show("DTS Package executed successfully.")\n            Else\n                MessageBox.Show("Failed to execute DTS Package.")\n            End If\n\n        Catch ex As Exception\n            MessageBox.Show("An error occurred: " & ex.Message)\n        Finally\n            ' Clean up the application object\n            dtsApplication = Nothing\n        End Try\n    End Sub\nEnd Class