private void SetWallpaper(string path)\n{\n    if (File.Exists(path))\n    {\n        using (Image imgInFile = Image.FromFile(path))\n        {\n            try\n            {\n                imgInFile.Save(SaveFile, ImageFormat.Bmp);\n                SystemParametersInfo(SPI_SETDESKWALLPAPER, 3, SaveFile, SPIF_UPDATEINIFILE | SPIF_SENDWININICHANGE);\n            }\n            catch\n            {\n                MessageBox.Show("error in setting the wallpaper");\n            }\n        }\n    }\n}