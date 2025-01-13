using System;\nusing System.Security;\nusing System.Security.Permissions;\n\n[UIPermission(SecurityAction.InheritanceDemand, Window = UIPermissionWindow.AllWindows)]\npublic class PrintData\n{\n    protected string Data = "secret value";\n\n    public virtual void PrintString()\n    {\n        Console.WriteLine(Data);\n    }\n}\n\npublic class DerivedPrintData : PrintData\n{\n    public override void PrintString()\n    {\n        // Attempt to override the method\n        base.PrintString();\n    }\n}\n\npublic class Program\n{\n    [STAThread]\n    public static void Main()\n    {\n        try\n        {\n            DerivedPrintData derivedData = new DerivedPrintData();\n            derivedData.PrintString();\n        }\n        catch (SecurityException e)\n        {\n            Console.WriteLine("SecurityException caught: " + e.Message);\n        }\n    }\n}