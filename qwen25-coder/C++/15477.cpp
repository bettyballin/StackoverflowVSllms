HRESULT hr = OleGetClipboard(&pDataObj);\nif (FAILED(hr)) {\n    if (hr == CLIPBRD_E_CANT_OPEN) {\n        // Handle the case where the clipboard couldn't be opened.\n        // This could involve logging an error, retrying after a delay, or notifying the user.\n        OutputDebugString(L"Failed to open clipboard. Error: CLIPBRD_E_CANT_OPEN\n");\n    } else {\n        // Handle other HRESULT errors as needed.\n        OutputDebugString(L"Another error occurred while accessing the clipboard.\n");\n    }\n}