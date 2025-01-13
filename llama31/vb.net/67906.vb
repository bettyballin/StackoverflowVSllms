Option Explicit\n\nPrivate Declare Function CreateProcess Lib "kernel32" _\n    (ByVal lpApplicationName As String, _\n     ByVal lpCommandLine As String, _\n     ByVal lpProcessAttributes As Long, _\n     ByVal lpThreadAttributes As Long, _\n     ByVal bInheritHandles As Long, _\n     ByVal dwCreationFlags As Long, _\n     ByVal lpEnvironment As String, _\n     ByVal lpCurrentDirectory As String, _\n     lpStartupInfo As STARTUPINFO, _\n     lpProcessInformation As PROCESS_INFORMATION) As Long\n\nPrivate Type STARTUPINFO\n    cb As Long\n    lpReserved As String\n    lpDesktop As String\n    lpTitle As String\n    dwX As Long\n    dwY As Long\n    dwXSize As Long\n    dwYSize As Long\n    dwXCountChars As Long\n    dwYCountChars As Long\n    dwFillAttribute As Long\n    dwFlags As Long\n    wShowWindow As Integer\n    cbReserved2 As Long\n    lpReserved2 As Long\n    hStdInput As Long\n    hStdOutput As Long\n    hStdError As Long\nEnd Type\n\nPrivate Type PROCESS_INFORMATION\n    hProcess As Long\n    hThread As Long\n    dwProcessId As Long\n    dwThreadId As Long\nEnd Type\n\nPublic Function DecryptFile(encryptedFile As String, privateKey As String) As String\n    Dim command As String\n    Dim startupInfo As STARTUPINFO\n    Dim processInfo As PROCESS_INFORMATION\n    \n    command = "gpg --quiet --batch --decrypt --passphrase-fd 0 --output " & _\n              encryptedFile & " " & privateKey\n    \n    startupInfo.cb = Len(startupInfo)\n    CreateProcess "gpg.exe", command, 0&, 0&, 1&, 0&, vbNullString, vbNullString, startupInfo, processInfo\n    \n    DecryptFile = encryptedFile\nEnd Functio