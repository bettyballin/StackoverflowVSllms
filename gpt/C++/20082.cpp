// ManagedWrapper.h\n   public ref class ManagedWrapper\n   {\n   private:\n       CYourComClass* pComObject;\n   public:\n       ManagedWrapper()\n       {\n           pComObject = new CYourComClass();\n       }\n       ~ManagedWrapper()\n       {\n           delete pComObject;\n       }\n       void ShowDialog()\n       {\n           pComObject->ShowDialog();\n       }\n   };