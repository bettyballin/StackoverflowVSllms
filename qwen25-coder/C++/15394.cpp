#include <iostream>\n#include <comdef.h>\n#import "NWLaserXControl.tlb" no_namespace\n\nint main() {\n    // Initialize COM library for current thread.\n    HRESULT hr = CoInitializeEx(NULL, COINIT_APARTMENTTHREADED);\n    if (FAILED(hr)) {\n        std::cerr << "Failed to initialize COM library. Error code: " << hr << std::endl;\n        return 1;  // Program has failed.\n    }\n\n    NWLaserXControl::INWLaserXPtr Laser;\n    try {\n        // Create the laser object.\n        hr = Laser.CreateInstance(__uuidof(NWLaserX));\n        if (FAILED(hr)) {\n            _com_error error(hr);\n            std::cerr << "Failed to create NWLaserX instance. Error: " \n                      << error.ErrorMessage() << std::endl;\n            CoUninitialize();\n            return 1; // Program has failed.\n        }\n\n        // Initialize the laser object.\n        if (Laser->Initialize()) {\n            Laser->RepRate = 10;         // set the rep rate to 10Hz\n            Laser->LaserEnabled = true;   // turn on laser power supply, get it ready\n        } else {\n            std::cerr << "Failed to initialize laser." << std::endl;\n        }\n    }\n    catch (_com_error &e) {\n        std::cerr << "Error: " << e.ErrorMessage() << std::endl;\n    }\n\n    // Uninitialize the COM library.\n    CoUninitialize();\n    return 0;\n}