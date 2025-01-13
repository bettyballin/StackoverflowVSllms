<%@ Application Language="C#" %>\n\n<script runat="server">\n    private static List<string> fileLocations = new List<string>();\n\n    void Application_Start(object sender, EventArgs e) \n    {\n        // Code that runs on application startup\n    }\n\n    void Application_End(object sender, EventArgs e) \n    {\n        // Code that runs on application shutdown\n        foreach (string file in fileLocations)\n        {\n            if (File.Exists(file))\n                File.Delete(file);\n        }\n    }\n\n    public static void AddFileLocation(string file)\n    {\n        lock (fileLocations)\n        {\n            fileLocations.Add(file);\n        }\n    }\n</script>