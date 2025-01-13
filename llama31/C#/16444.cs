using NetCDF;\n\nclass Program\n{\n    static void Main(string[] args)\n    {\n        // Create a new NetCDF file\n        using (var ncFile = new NcFile("example.nc", FileMode.Create))\n        {\n            // Create a new dimension\n            var timeDim = ncFile.AddDimension("time", 10);\n\n            // Create a new variable\n            var timeVar = ncFile.AddVariable("time", NcType.NC_INT, new[] { timeDim });\n\n            // Write data to the variable\n            var timeData = Enumerable.Range(1, 10).ToArray();\n            timeVar.Write(timeData);\n\n            // Close the file\n            ncFile.Close();\n        }\n    }\n}