HKEY hkey;\nDWORD dwDisposition, dwType, dwSize;\nint autorun = 0x00;\nint CD_AUTORUN_DISABLED = 0x20;\nlong errorCode;\n\nerrorCode = RegOpenKeyEx(HKEY_LOCAL_MACHINE, TEXT("Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer"), 0, KEY_ALL_ACCESS, &hkey);\n\nif(errorCode == ERROR_SUCCESS) {\n    dwType = REG_DWORD;\n    dwSize = sizeof(dwType);\n    errorCode = RegQueryValueEx(hkey, TEXT("NoDriveTypeAutoRun"), NULL, &dwType, (PBYTE)&autorun, &dwSize);\n\n    cout << "Autorun value: " << autorun << endl;\n    if((autorun & CD_AUTORUN_DISABLED) == 0x20){\n        int newAutorun = (autorun - CD_AUTORUN_DISABLED);\n        cout << "New value: " << newAutorun  << endl;\n\n        // Set the new value using RegSetValueEx\n        DWORD newValue = newAutorun;\n        errorCode = RegSetValueEx(hkey, TEXT("NoDriveTypeAutoRun"), 0, REG_DWORD, (PBYTE) &newValue, sizeof(newValue));\n\n        if(errorCode == ERROR_SUCCESS){\n            errorCode = RegCloseKey(hkey);             \n            if(errorCode == ERROR_SUCCESS){\n                cout << "Value changed." << endl;\n            }\n        }else{\n            cout << "Value change failed, error code: " << errorCode << endl;\n        }\n    }else{\n        cout << "Keep current value." << endl;\n    }\n\n}else{\n    if(errorCode == ERROR_ACCESS_DENIED){\n        cout << "Access denied." << endl;\n    }else{\n        cout << "Error! " << errorCode << " : " << ERROR_SUCCESS << endl;\n    }\n}