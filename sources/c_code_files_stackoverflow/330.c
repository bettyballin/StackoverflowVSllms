#include <Windows.h>
#include <iostream>
#include <fstream>

int main() {
    FILETIME f4;
    SYSTEMTIME stUTC;

    // Replace this with your actual file time
    f4.dwLowDateTime = 0;
    f4.dwHighDateTime = 0;

    FileTimeToSystemTime(&f4, &stUTC);
    std::cout << "Thread1: Hour:" << stUTC.wHour << " Min:" << stUTC.wMinute << " Sec:" << stUTC.wSecond << " millSec:" << stUTC.wMilliseconds << std::endl;

    return 0;
}