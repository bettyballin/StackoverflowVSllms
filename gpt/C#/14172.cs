// File: YourDataContext.Partial.cs\n   public partial class YourDataContext\n   {\n       partial void OnEmailIdChanging(string value)\n       {\n           if (string.IsNullOrEmpty(value) || !value.Contains("@"))\n           {\n               throw new ArgumentException("Invalid email address.");\n           }\n       }\n   }