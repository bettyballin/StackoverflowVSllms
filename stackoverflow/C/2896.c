typedef basic_string<TCHAR> tstring;\ntypedef map<tstring, tstring> HardDiskCollection;\n\nvoid Initialise( HardDiskCollection &_hardDiskCollection )\n{\n    TCHAR tszLinkName[MAX_PATH] = { 0 };\n    TCHAR tszDevName[MAX_PATH] = { 0 };\n    TCHAR tcDrive = 0;\n\n    _tcscpy_s( tszLinkName, MAX_PATH, _T("a:") );\n    for ( tcDrive = _T('a'); tcDrive < _T('z'); ++tcDrive )\n    {\n        tszLinkName[0] = tcDrive;\n        if ( QueryDosDevice( tszLinkName, tszDevName, MAX_PATH ) )\n        {\n            _hardDiskCollection.insert( pair<tstring, tstring>( tszLinkName, tszDevName ) );\n        }\n    }\n}