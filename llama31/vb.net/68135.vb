Dim pkg As New Package\nDim app As New Microsoft.SqlServer.Dts.Runtime.Application\nDim pkgResults As DTSExecResult\nDim eventListener As New EventListener()\n\nTry\n    pkgLocation = "C:\SSIS_DataTransfer\ImportPackage.dtsx"\n    Dim mdbFilePath As String = "C:\Path\To\Your\mdbFile.mdb"\n\n    pkg = app.LoadPackage(pkgLocation, eventListener, New PackageParameters() {New PackageParameter("mdbFilePath", mdbFilePath)})\n    pkgResults = pkg.Execute(Nothing, Nothing, eventListener, Nothing, Nothing)\n\n    Select Case pkgResults\n        Case DTSExecResult.Completion\n            MsgBox("Data import completed!")\n        Case DTSExecResult.Success\n            MsgBox("Data import was successful!")\n        Case DTSExecResult.Failure\n            MsgBox("Data import was not successful!")\n    End Select\n\nCatch ex As Exception\n    MsgBox(ex.Message)\nEnd Try