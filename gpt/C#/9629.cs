using System;\n   using System.Security;\n\n   public class ComInteropWrapper\n   {\n       [SecurityCritical]\n       public void CallUnmanagedCode()\n       {\n           // Implement calls to unmanaged code here\n       }\n\n       [SecuritySafeCritical]\n       public void SafeMethod()\n       {\n           // Perform necessary validations and then call the critical method\n           CallUnmanagedCode();\n       }\n   }