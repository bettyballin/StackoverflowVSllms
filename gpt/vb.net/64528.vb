Sub ControlDevice()\n        Dim device As Object\n        Dim response As String\n        Dim data As String\n\n        ' Create an instance of the COM object\n        Set device = CreateObject("MyDeviceControllerLib.MyDeviceController")\n\n        ' Send a command to the device\n        response = device.SendCommand("TurnOn")\n        MsgBox "Response: " & response\n\n        ' Get data from the device\n        data = device.GetData()\n        MsgBox "Data: " & data\n\n        ' Release the COM object\n        Set device = Nothing\n    End Sub