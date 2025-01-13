using(ICSharpCode.SharpZipLib.Zip.FastZip fZip = new ICSharpCode.SharpZipLib.Zip.FastZip())\n{\n    try \n    {\n        fZip.CreateEmptyDirectories = true;\n        fZip.CreateZip(filesPath + "\\" + this.zipName, filesPath, false, this.zipFilter);\n        \n        // Optionally add a delay before deleting as a test\n        System.Threading.Thread.Sleep(100); // Delay for 100 milliseconds\n\n        // Attempt to delete the file\n        File.Delete(filesPath + "\\" + this.zipName);\n    } \n    catch (Exception ex) \n    {\n        Console.WriteLine("An error occurred: " + ex.Message);\n    }\n}