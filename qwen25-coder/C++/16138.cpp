// AssemblyCleanup.cpp\n#pragma managed\n\nvoid OnUnload() {\n    // Cleanup code here\n    Console::WriteLine("Assembly unloading.");\n}\n\n[System::Runtime::InteropServices::ModuleUninitializerAttribute]\nstatic void ModuleUnloading() {\n    OnUnload();\n}