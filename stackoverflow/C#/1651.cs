public static ImageFormat getImageFileFormat( string filename )\n    {\n        using ( var fs = new System.IO.FileStream( filename, System.IO.FileMode.Open ) )\n        using ( var img = Image.FromStream( fs, true, false ) )\n            return img.RawFormat;\n    }