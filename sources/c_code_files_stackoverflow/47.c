#include <tchar.h>
#include <map>
#include <string>
#include <Windows.h>

typedef std::basic_string<TCHAR> tstring;
typedef std::map<tstring, tstring> HardDiskCollection;

void Initialise(HardDiskCollection &_hardDiskCollection)
{
    TCHAR tszLinkName[MAX_PATH] = { 0 };
    TCHAR tszDevName[MAX_PATH] = { 0 };
    TCHAR tcDrive = 0;

    _tcscpy_s(tszLinkName, MAX_PATH, _T("a:"));
    for (tcDrive = _T('a'); tcDrive <= _T('z'); ++tcDrive)
    {
        tszLinkName[0] = tcDrive;
        if (QueryDosDevice(tszLinkName, tszDevName, MAX_PATH))
        {
            _hardDiskCollection.insert(std::pair<tstring, tstring>(tszLinkName, tszDevName));
        }
    }
}

int main()
{
    HardDiskCollection hardDiskCollection;
    Initialise(hardDiskCollection);
    return 0;
}