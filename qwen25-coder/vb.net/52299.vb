' Declare the DLL function\nPrivate Declare Sub Out32 Lib "inpout32.dll" (ByVal PortAddress As Integer, ByVal Data As Integer)\n\nSub WriteToParallelPort()\n    Dim portAddress As Integer = &H378 ' or &H3BC for EPP/ECP mode\n    Dim dataToSend As Byte = 15         ' Example data to send\n\n    Out32(portAddress, dataToSend)\nEnd Sub