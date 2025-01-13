Dim reg As New StdRegistry\n\nPublic Function CurrentWallpaper() As String\n    CurrentWallpaper = reg.ValueEx(HKEY_CURRENT_USER, "Control Panel\Desktop", "Wallpaper", REG_SZ, "")\nEnd Function\n\nPublic Sub SetWallpaper(cFilename As Variant)\n    reg.ClassKey = HKEY_CURRENT_USER\n    reg.SectionKey = "Control Panel\Desktop"\n    reg.ValueKey = "Wallpaper"\n    reg.ValueType = REG_SZ\n    reg.Default = ""\n    reg.Value = cFilename\n    \n    ' Set wallpaper style to HTML\n    reg.ValueKey = "WallpaperStyle"\n    reg.Value = "HTML"\n    \n    ' Set wallpaper MIME type\n    reg.ValueKey = "WallpaperMimeType"\n    reg.Value = "text/html"\nEnd Sub\n\nPublic Sub RefreshDesktop()\n    Dim oShell As Object\n    Set oShell = CreateObject("WScript.Shell")\n    oShell.Run "%windir%\System32\RUNDLL32.EXE user32.dll,UpdatePerUserSystemParameters", 1, True\nEnd Sub