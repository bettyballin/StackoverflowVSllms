// ManagedCSharpWrapper.dll (C++/CLI)\n     #using <System.dll>\n     #using "YourCsharpLibrary.dll"\n\n     using namespace System;\n\n     public ref class ManagedCSharpBridge {\n     public:\n         static int CallCSharpFunction(int value) {\n             YourNamespace::YourClass^ cSharpInstance = gcnew YourNamespace::YourClass();\n             return cSharpInstance->YourMethod(value);\n         }\n     };