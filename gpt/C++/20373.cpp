#include <windows.h>\n#include <iostream>\n#include <batclass.h>\n\nbool IsAcPowerConnected() {\n    HANDLE hBattery;\n    ULONG batteryTag;\n    BATTERY_QUERY_INFORMATION bqi;\n    BATTERY_INFORMATION bi;\n    DWORD dwWait;\n    DWORD dwOut;\n    BOOL bResult;\n\n    hBattery = CreateFile(\n        "\\\\.\\Battery0",\n        GENERIC_READ | GENERIC_WRITE,\n        FILE_SHARE_READ | FILE_SHARE_WRITE,\n        NULL,\n        OPEN_EXISTING,\n        0,\n        NULL\n    );\n\n    if (hBattery == INVALID_HANDLE_VALUE) {\n        std::cerr << "Failed to open battery device." << std::endl;\n        return false;\n    }\n\n    bResult = DeviceIoControl(\n        hBattery,\n        IOCTL_BATTERY_QUERY_TAG,\n        NULL,\n        0,\n        &batteryTag,\n        sizeof(batteryTag),\n        &dwOut,\n        NULL\n    );\n\n    if (!bResult) {\n        std::cerr << "Failed to query battery tag." << std::endl;\n        CloseHandle(hBattery);\n        return false;\n    }\n\n    bqi.BatteryTag = batteryTag;\n    bqi.InformationLevel = BatteryInformation;\n    bqi.AtRate = 0;\n\n    bResult = DeviceIoControl(\n        hBattery,\n        IOCTL_BATTERY_QUERY_INFORMATION,\n        &bqi,\n        sizeof(bqi),\n        &bi,\n        sizeof(bi),\n        &dwOut,\n        NULL\n    );\n\n    if (!bResult) {\n        std::cerr << "Failed to query battery information." << std::endl;\n        CloseHandle(hBattery);\n        return false;\n    }\n\n    CloseHandle(hBattery);\n    return (bi.PowerState & BATTERY_POWER_ON_LINE) != 0;\n}\n\nint main() {\n    if (IsAcPowerConnected()) {\n        std::cout << "AC power is connected." << std::endl;\n    } else {\n        std::cout << "AC power is not connected." << std::endl;\n    }\n\n    return 0;\n}