Public Sub OnConnection(ByVal application As Object, ByVal connectMode As ext_ConnectMode, ByVal addInInst As Object, ByRef custom As Array) Implements IDTExtensibility2.OnConnection\n    Dim dte2 As DTE2 = TryCast(application, DTE2)\n    If dte2 IsNot Nothing AndAlso dte2.CommandLineArguments.Contains("/useenv") Then\n        ' build is being invoked from command line\n    End If\nEnd Sub