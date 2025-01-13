using System;\nusing System.Web.Hosting;\n\npublic class DynamicPageProvider : VirtualPathProvider\n{\n    public override VirtualFile GetFile(string virtualPath)\n    {\n        // Check if the virtual path matches your dynamic page\n        if (virtualPath == "~/WRC/test.aspx")\n        {\n            // Return a VirtualFile object that represents your dynamic page\n            return new DynamicPageFile(virtualPath);\n        }\n        return base.GetFile(virtualPath);\n    }\n}\n\npublic class DynamicPageFile : VirtualFile\n{\n    public DynamicPageFile(string virtualPath) : base(virtualPath)\n    {\n    }\n\n    public override Stream Open()\n    {\n        // Return a stream that contains the content of your dynamic page\n        // In this case, we're just returning a simple string\n        return new MemoryStream(Encoding.UTF8.GetBytes("You are very lucky!!!"));\n    }\n}