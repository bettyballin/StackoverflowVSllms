std::locale loc("");\nstd::wstring s = boost::str(boost::format(L"Hello, %s!", loc) % L"World");\nstd::wcout << s << std::endl;