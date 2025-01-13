using System;\nusing System.IO;\nusing System.Web.SessionState;\n\npublic class ImageManager\n{\n    private string _tempFolder;\n\n    public ImageManager(string tempFolder)\n    {\n        _tempFolder = tempFolder;\n    }\n\n    public string SaveImage(byte[] imageBytes)\n    {\n        string imageName = Guid.NewGuid().ToString() + ".jpg";\n        string imagePath = Path.Combine(_tempFolder, imageName);\n        File.WriteAllBytes(imagePath, imageBytes);\n        return imageName;\n    }\n\n    public void Cleanup()\n    {\n        DirectoryInfo di = new DirectoryInfo(_tempFolder);\n        FileInfo[] files = di.GetFiles();\n        foreach (FileInfo file in files)\n        {\n            if (file.CreationTime < DateTime.Now.AddHours(-1))\n            {\n                file.Delete();\n            }\n        }\n    }\n}\n\npublic class SessionImageManager\n{\n    private ImageManager _imageManager;\n\n    public SessionImageManager(ImageManager imageManager)\n    {\n        _imageManager = imageManager;\n    }\n\n    public void Session_End(object sender, EventArgs e)\n    {\n        _imageManager.Cleanup();\n    }\n}