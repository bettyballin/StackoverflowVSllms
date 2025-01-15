#include <Windows.h>
#include <atlstr.h> // for CString
#include <string>

class AutoHandle
{
    HANDLE  mHandle;
public:
    AutoHandle() : mHandle(NULL) { }
    AutoHandle(HANDLE h) : mHandle(h) { }

    HANDLE * operator & ()
    {
        return &mHandle;
    }

    operator HANDLE() const
    {
        return mHandle;
    }

    ~AutoHandle()
    {
        if (mHandle && mHandle != INVALID_HANDLE_VALUE)
            ::CloseHandle(mHandle);
    }
};

bool
GetDiskPowerState(LPCTSTR disk, std::string & txt)
{
    AutoHandle hFile = CreateFile(disk, 0, FILE_SHARE_READ|FILE_SHARE_WRITE, NULL, OPEN_EXISTING, 0, NULL);
    if (hFile && hFile != INVALID_HANDLE_VALUE)
    {
        BOOL powerState = FALSE;
        const BOOL result = GetDevicePowerState(hFile, &powerState);
        const DWORD err = GetLastError();

        if (result)
        {
            if (powerState)
            {
                txt += disk;
                txt += " : powered up\r\n";
            }
            else
            {
                txt += disk;
                txt += " : sleeping\r\n";
            }
            return true;
        }
        else
        {
            txt += "Cannot get drive ";
            txt += disk;
            txt += "status\r\n";
            return false;
        }
    }

    return false;
}

std::string 
GetDiskPowerState()
{
    std::string text;
    CString driveName;
    bool result = true;
    for (int idx= 0; result; idx++)
    {
        driveName.Format("\\\\.\\PhysicalDrive%d", idx);
        result = GetDiskPowerState(driveName, text);
    }
    return text;
}

int main()
{
    std::string result = GetDiskPowerState();
    printf("%s", result.c_str());
    return 0;
}