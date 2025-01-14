Sub GetRAMInfo()\n    Dim objWMIService As Object\n    Dim colItems As Object\n    Dim objItem As Object\n    Dim strComputer As String\n\n    ' Connect to the WMI service on the local computer.\n    strComputer = "."\n    Set objWMIService = GetObject("winmgmts:\\" & strComputer & "\root\cimv2")\n\n    ' Query for memory information.\n    Set colItems = objWMIService.ExecQuery("Select * from Win32_PhysicalMemory")\n\n    ' Loop through the results and output each memory module's details.\n    For Each objItem In colItems\n        Debug.Print "BankLabel: " & objItem.BankLabel\n        Debug.Print "Capacity: " & (objItem.Capacity / 1024 / 1024) & " MB"\n        Debug.Print "DeviceID: " & objItem.DeviceID\n        Debug.Print "FormFactor: " & objItem.FormFactor\n        Debug.Print "Speed: " & objItem.Speed & " MHz"\n        Debug.Print "-----------------------------------"\n    Next\n\n    ' Clean up.\n    Set objWMIService = Nothing\n    Set colItems = Nothing\nEnd Sub