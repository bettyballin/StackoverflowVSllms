// CommandLineInterface.h\nclass ICommandLineInterface {\npublic:\n    virtual void ExecuteCommand(const std::string& command) = 0;\n};\n\n// AutoCADCLI.h (uses Object ARX)\n#include "CommandLineInterface.h"\n\nclass AutoCADCLI : public ICommandLineInterface {\npublic:\n    void ExecuteCommand(const std::string& command) override {\n        // Implement using acutPrintf, acad_strcpy, etc.\n    }\n};\n\n// IntelliCADCLI.h (uses ADS)\n#include "CommandLineInterface.h"\n\nclass IntelliCADCLI : public ICommandLineInterface {\npublic:\n    void ExecuteCommand(const std::string& command) override {\n        // Implement using ads_printf, acedGetAppName, etc.\n    }\n};\n\n// YourApplication.cpp\nvoid Initialize(ICommandLineInterface* cli) {\n    cli->ExecuteCommand("HELLO");\n}\n\nint main() {\n    // For AutoCAD\n    AutoCADCLI autoCADCli;\n    Initialize(&autoCADCli);\n\n    // For IntelliCAD\n    IntelliCADCLI intelliCADCli;\n    Initialize(&intelliCADCli);\n\n    return 0; // or acrx_unlock_app in AutoCAD context\n}