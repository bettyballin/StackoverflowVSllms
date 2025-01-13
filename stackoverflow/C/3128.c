CString GetCallingFilename(bool includePath)\n{\n    CString filename;\n    GetModuleFileName(AfxGetInstanceHandle(), filename.GetBuffer(MAX_PATH), MAX_PATH);\n\n    filename.ReleaseBuffer();\n\n    if( !includePath )\n    {\n        int filenameStart = filename.ReverseFind('\\') + 1;\n        if( filenameStart > 0 )\n        {\n            filename = filename.Mid(filenameStart);\n        }\n    }\n\n    return filename;\n}\n\nCString GetCallingVersionNumber(const CString& filename)\n{\n    DWORD fileHandle, fileVersionInfoSize;\n    UINT bufferLength;\n    LPTSTR lpData;\n    VS_FIXEDFILEINFO *pFileInfo;\n\n    fileVersionInfoSize = GetFileVersionInfoSize(filename, &fileHandle);\n    if( !fileVersionInfoSize )\n    {\n        return "";\n    }\n\n    lpData = new TCHAR[fileVersionInfoSize];\n    if( !lpData )\n    {\n        return "";\n    }\n\n    if( !GetFileVersionInfo(filename, fileHandle, fileVersionInfoSize, lpData) )\n    {\n        delete [] lpData;\n        return "";\n    }\n\n    if( VerQueryValue(lpData, "\\", (LPVOID*)&pFileInfo, (PUINT)&bufferLength) ) \n    {\n        WORD majorVersion = HIWORD(pFileInfo->dwFileVersionMS);\n        WORD minorVersion = LOWORD(pFileInfo->dwFileVersionMS);\n        WORD buildNumber = HIWORD(pFileInfo->dwFileVersionLS);\n        WORD revisionNumber = LOWORD(pFileInfo->dwFileVersionLS);\n\n        CString fileVersion;\n        fileVersion.Format("%d.%d.%d.%d", majorVersion, minorVersion, buildNumber, revisionNumber);\n\n        delete [] lpData;\n        return fileVersion;\n    }\n\n    delete [] lpData;\n    return "";\n}