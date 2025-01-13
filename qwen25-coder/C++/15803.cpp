ULONG bufferLength = 256; // Initial guess for buffer size\nWCHAR* buffer = new WCHAR[bufferLength];\n\nHRESULT hr = pComObject->GetText(&bufferLength, buffer);\nif (SUCCEEDED(hr)) {\n    wprintf(L"Received: %s\n", buffer);\n} else if (hr == E_INVALIDARG) {\n    // Allocate more space and try again\n    delete[] buffer;\n    buffer = new WCHAR[bufferLength]; // Use the required length from server\n    hr = pComObject->GetText(&bufferLength, buffer);\n    if (SUCCEEDED(hr)) {\n        wprintf(L"Received: %s\n", buffer);\n    }\n}\n\ndelete[] buffer; // Clean up allocated memory