using System.Diagnostics;\n\nclass Program\n{\n    static void Main()\n    {\n        // Step 1: Convert each page of the PDF to a separate image\n        ProcessStartInfo startInfo = new ProcessStartInfo\n        {\n            FileName = "gswin64c.exe",\n            Arguments = "-q -dNOPAUSE -dBATCH -sDEVICE=png16m -r300x300 -sOutputFile=\"output_%03d.png\" GLOSS.pdf",\n            RedirectStandardOutput = true,\n            UseShellExecute = false,\n        };\n        Process.Start(startInfo).WaitForExit();\n\n        // Step 2: Append all images to a single image using ImageMagick\n        startInfo.Arguments = "convert output_*.png -append final_output.png";\n        startInfo.FileName = "magick.exe"; // Ensure ImageMagick is installed and magick.exe is in PATH\n        Process.Start(startInfo).WaitForExit();\n    }\n}