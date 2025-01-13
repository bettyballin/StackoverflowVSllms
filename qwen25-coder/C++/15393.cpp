// Example of a simple C++/CLI wrapper\n#include <msclr/marshal_cppstd.h>\n\nusing namespace std;\nusing namespace msclr::interop;\n\nextern "C" __declspec(dllexport) void CallNativeFunction(vector<double>& data);\n\npublic ref class WrapperClass\n{\n    public: \n        static void ManagedFunction(cli::array<double>^ managedData)\n        {\n            pin_ptr<double> pinnedPtr = &managedData[0];\n            vector<double> nativeData(pinnedPtr, pinnedPtr + managedData->Length);\n            CallNativeFunction(nativeData);\n        }\n};