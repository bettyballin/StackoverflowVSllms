using System;\nusing System.Runtime.InteropServices;\n\nnamespace MyDotNetLibrary\n{\n    [ComVisible(true)]\n    [Guid("12345678-1234-1234-1234-123456789012")] // Ensure this is a unique GUID.\n    public interface IMyDotNetLibrary\n    {\n        string GetData();\n        void SetData(string data);\n    }\n\n    [ComVisible(true)]\n    [ClassInterface(ClassInterfaceType.None)]\n    [Guid("98765432-1234-1234-1234-123456789012")] // Ensure this is a unique GUID.\n    public class MyDotNetLibrary : IMyDotNetLibrary\n    {\n        private string _data;\n\n        public virtual string GetData()\n        {\n            return _data;\n        }\n\n        public virtual void SetData(string data)\n        {\n            _data = data;\n        }\n    }\n}