var files = new List<string>();\n     //@Stan R. suggested an improvement to handle floppy drives...\n     //foreach (DriveInfo d in DriveInfo.GetDrives())\n     foreach (DriveInfo d in DriveInfo.GetDrives().Where(x => x.IsReady == true))\n     {\n        files.AddRange(Directory.GetFiles(d.RootDirectory.FullName, "Cheese.exe", SearchOption.AllDirectories));\n     }