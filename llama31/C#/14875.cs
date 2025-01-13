using System;\nusing System.Data;\nusing System.Data.SqlTypes;\nusing Microsoft.SqlServer.Server;\n\n[SqlUserDefinedType(Format.Native, Name = "MyUDT")]\npublic struct MyUDT : INullable\n{\n    private int value;\n\n    public MyUDT(int value)\n    {\n        this.value = value;\n    }\n\n    public override string ToString()\n    {\n        return value.ToString();\n    }\n\n    public bool IsNull\n    {\n        get { return false; }\n    }\n\n    public static MyUDT Null\n    {\n        get { return new MyUDT(0); }\n    }\n}