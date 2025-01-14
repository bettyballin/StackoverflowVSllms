#include <windows.h>
#include <tchar.h>
#include <stdio.h>

// Define the buffer size for the volume name
#define BUFSIZE 1024

int _tmain(int argc, TCHAR* argv[])
{
    // Declare variables
    BOOL bFlag;
    TCHAR Buf[BUFSIZE]; // temporary buffer for volume name
    BOOL bHavePrivilege; // Assume this is defined elsewhere

    // ... (rest of the code remains the same)

    bFlag = GetVolumeNameForVolumeMountPoint(argv[2],  // input volume mount point or file system directory
                             Buf,     // output volume name buffer
                             BUFSIZE);   // size of volume name buffer
    if (bFlag != TRUE) { PrintUsageAndExit("Retrieving volume name...", -2); }

    _tprintf(TEXT("Volume name of %s is %s\n"), argv[2], Buf);

    // Check privileges before SetVolumeMountPoint call:
    if (!bHavePrivilege) { PrintUsageAndExit("User lacks required privilege.",-3); }

    // Perform mounting
    bFlag = SetVolumeMountPoint(argv[1],    // mount point
              Buf);     // volume to be mounted
    // ... (rest of the code remains the same)

    return 0;
}