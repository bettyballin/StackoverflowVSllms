using Microsoft.VisualBasic.Devices;\n\n// Get the number of desktops\nint desktopCount = My.Computer.Screen.AllScreens.Count;\n\n// Loop through each desktop\nforeach (Screen screen in My.Computer.Screen.AllScreens)\n{\n    // Get the resolution of each desktop\n    int width = screen.Bounds.Width;\n    int height = screen.Bounds.Height;\n}