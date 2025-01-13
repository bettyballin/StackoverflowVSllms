#include <windows.h>\n#include <mmdeviceapi.h>\n#include <audiopolicy.h>\n\n// Assuming you have an IAudioSessionControl2 instance\nIAudioSessionControl2* pSessionControl = ...;\n\n// Get the ISimpleAudioVolume interface\nISimpleAudioVolume* pSimpleVolume = NULL;\nHRESULT hr = pSessionControl->QueryInterface(IID_PPV_ARGS(&pSimpleVolume));\nif (SUCCEEDED(hr)) {\n    // Get the current volume level\n    float fVolume = 0.0f;\n    hr = pSimpleVolume->GetMasterVolume(&fVolume);\n    if (SUCCEEDED(hr)) {\n        // fVolume now holds the current volume level (range: 0.0 to 1.0)\n    }\n    pSimpleVolume->Release();\n}