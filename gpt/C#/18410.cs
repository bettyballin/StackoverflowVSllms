using System;\nusing System.Security;\n\n[assembly: AllowPartiallyTrustedCallers]\n\nnamespace MyNamespace\n{\n    public class Program\n    {\n        [SecuritySafeCritical]\n        public static void Main(string[] args)\n        {\n            // Your main code here\n        }\n\n        [SecurityCritical]\n        private static void FullTrustOnlyMethod()\n        {\n            // This method requires full trust\n        }\n\n        [SecurityTransparent]\n        public static void PartialTrustMethod()\n        {\n            // This method can run in partial trust\n        }\n    }\n}