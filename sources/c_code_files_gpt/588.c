#include <windows.h>
#include <winioctl.h>
#include <stdio.h>

void GetDriveGeometry(const char* drivePath) {
    HANDLE hDevice = CreateFileA(
        drivePath,
        0,
        FILE_SHARE_READ | FILE_SHARE_WRITE,
        NULL,
        OPEN_EXISTING,
        0,
        NULL
    );

    if (hDevice == INVALID_HANDLE_VALUE) {
        printf("Failed to open device. Error: %lu\n", GetLastError());
        return;
    }

    DISK_GEOMETRY dg = { 0 };
    DWORD bytesReturned = 0;

    if (!DeviceIoControl(
        hDevice,
        IOCTL_DISK_GET_DRIVE_GEOMETRY,
        NULL,
        0,
        &dg,
        sizeof(dg),
        &bytesReturned,
        NULL
    )) {
        printf("Failed to get drive geometry. Error: %lu\n", GetLastError());
        CloseHandle(hDevice);
        return;
    }

    printf("Cylinders: %I64d\n", dg.Cylinders);
    printf("Tracks per cylinder: %lu\n", dg.TracksPerCylinder);
    printf("Sectors per track: %lu\n", dg.SectorsPerTrack);
    printf("Bytes per sector: %lu\n", dg.BytesPerSector);

    CloseHandle(hDevice);
}

int main() {
    GetDriveGeometry("\\\\.\\PhysicalDrive0");
    return 0;
}