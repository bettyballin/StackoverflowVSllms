using System;\n\npublic class ComChecker\n{\n    public static bool IsComComponentInstalled(string progId)\n    {\n        Type comType = Type.GetTypeFromProgID(progId);\n        return comType != null;\n    }\n\n    public static void Main(string[] args)\n    {\n        string comProgId = "YourComComponent.ProgID"; // Replace with your COM component's ProgID\n        if (IsComComponentInstalled(comProgId))\n        {\n            Console.WriteLine("The COM component is installed.");\n        }\n        else\n        {\n            Console.WriteLine("The COM component is not installed.");\n        }\n    }\n}