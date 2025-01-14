#include <Windows.h>
#include <stdio.h>

int main() {
    DWORD sectorsPerCluster, bytesPerSector, freeClusters, totalClusters;
    char rootPath[] = "C:\\";
    
    if (GetDiskFreeSpace(rootPath, &sectorsPerCluster, &bytesPerSector, &freeClusters, &totalClusters)) {
        printf("Sectors per cluster: %lu\n", sectorsPerCluster);
        printf("Bytes per sector: %lu\n", bytesPerSector);
        printf("Number of free clusters: %lu\n", freeClusters);
        printf("Total number of clusters: %lu\n", totalClusters);
    } else {
        printf("Failed to get disk free space information.\n");
    }
    
    return 0;
}