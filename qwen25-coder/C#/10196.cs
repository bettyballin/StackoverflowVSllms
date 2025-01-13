// C# managed class wrapping the unmanaged class\n   public class MyManagedWrapper {\n       private IntPtr _unmanagedInstance;\n\n       [DllImport("MyUnmanagedDll.dll", CallingConvention = CallingConvention.Cdecl)]\n       private static extern IntPtr CreateMyUnmanagedClass();\n\n       [DllImport("MyUnmanagedDll.dll", CallingConvention = CallingConvention.Cdecl)]\n       private static extern void DestroyMyUnmanagedClass(IntPtr instance);\n\n       [DllImport("MyUnmanagedDll.dll", CallingConvention = CallingConvention.Cdecl)]\n       private static extern void MyUnmanagedMethod(IntPtr instance);\n\n       public MyManagedWrapper() {\n           _unmanagedInstance = CreateMyUnmanagedClass();\n       }\n\n       ~MyManagedWrapper() {\n           if (_unmanagedInstance != IntPtr.Zero) {\n               DestroyMyUnmanagedClass(_unmanagedInstance);\n               _unmanagedInstance = IntPtr.Zero;\n           }\n       }\n\n       public void MethodThatCallsUnmanagedCode() {\n           MyUnmanagedMethod(_unmanagedInstance);\n       }\n   }