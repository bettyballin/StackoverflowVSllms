pp
#include <iostream>
#include <string>
#include <Windows.h>

std::string GetCallingFilename(bool includePath)
{
    char filename[MAX_PATH];
    GetModuleFileNameA(NULL, filename, MAX_PATH);

    if (!includePath)
    {
        char* filenameStart = strrchr(filename, '\\');
        if (filenameStart != NULL)
        {
            filenameStart++;
            return std::string(filenameStart);
        }
    }

    return std::string(filename);
}

std::string GetCallingVersionNumber(const std::string& filename)
{
    DWORD fileVersionInfoSize;
    UINT bufferLength;
    char* lpData;
    VS_FIXEDFILEINFO *pFileInfo;

    fileVersionInfoSize = GetFileVersionInfoSizeA(filename.c_str(), NULL);
    if (!fileVersionInfoSize)
    {
        return "";
    }

    lpData = new char[fileVersionInfoSize];
    if (!lpData)
    {
        return "";
    }

    if (!GetFileVersionInfoA(filename.c_str(), NULL, fileVersionInfoSize, lpData))
    {
        delete[] lpData;
        return "";
    }

    if (VerQueryValueA(lpData, "\\", (LPVOID*)&pFileInfo, (PUINT)&bufferLength))
    {
        WORD majorVersion = HIWORD(pFileInfo->dwFileVersionMS);
        WORD minorVersion = LOWORD(pFileInfo->dwFileVersionMS);
        WORD buildNumber = HIWORD(pFileInfo->dwFileVersionLS);
        WORD revisionNumber = LOWORD(pFileInfo->dwFileVersionLS);

        char fileVersion[256];
        sprintf_s(fileVersion, 256, "%d.%d.%d.%d", majorVersion, minorVersion, buildNumber, revisionNumber);

        delete[] lpData;
        return std::string(fileVersion);
    }

    delete[] lpData;
    return "";
}

int main()
{
    std::string filename = GetCallingFilename(false);
    std::cout << "Filename: " << filename << std::endl;

    std::string version = GetCallingVersionNumber(filename);
    std::cout << "Version: " << version << std::endl;

    return 0;
}