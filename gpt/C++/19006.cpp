int main()\n{\n    MyClassWrapper^ wrapper = gcnew MyClassWrapper();\n    int result = wrapper->CallManagedFunction(10);\n    // Use result\n    return 0;\n}