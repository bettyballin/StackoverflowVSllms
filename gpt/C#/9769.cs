using System;\nusing System.Runtime.InteropServices;\nusing System.Web;\n\n[ComVisible(true)]\n[Guid("YOUR-GUID-HERE")]\n[InterfaceType(ComInterfaceType.InterfaceIsIDispatch)]\npublic interface IMyComComponent\n{\n    string GetMapPath(string virtualPath);\n}\n\n[ComVisible(true)]\n[Guid("YOUR-GUID-HERE")]\n[ClassInterface(ClassInterfaceType.None)]\npublic class MyComComponent : IMyComComponent\n{\n    public string GetMapPath(string virtualPath)\n    {\n        if (HttpContext.Current == null)\n        {\n            throw new InvalidOperationException("HttpContext is not available.");\n        }\n        \n        return HttpContext.Current.Server.MapPath(virtualPath);\n    }\n}