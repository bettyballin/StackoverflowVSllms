Dim oQuery As System.Management.ObjectQuery = New System.Management.ObjectQuery("select FreeSpace,Size,Name from Win32_LogicalDisk where DriveType=3 AND name='Y'")