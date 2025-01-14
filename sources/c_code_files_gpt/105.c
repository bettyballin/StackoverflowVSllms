#include <stdio.h>
#include <stdint.h>

// Define the structure of the boot sector
#pragma pack(push, 1)
typedef struct {
    uint8_t  jump[3];
    char     oem[8];
    uint16_t bytes_per_sector;
    uint8_t  sectors_per_cluster;
    uint16_t reserved_sectors;
    uint8_t  num_fats;
    uint16_t root_entries;
    uint16_t total_sectors_short; // if zero, later field is used
    uint8_t  media_descriptor;
    uint16_t fat_size_sectors;
    uint16_t sectors_per_track;
    uint16_t num_heads;
    uint32_t hidden_sectors;
    uint32_t total_sectors_long;
    // Extended BIOS Parameter Block
    uint8_t  drive_number;
    uint8_t  reserved1;
    uint8_t  boot_signature;
    uint32_t volume_id;
    char     volume_label[11];
    char     fs_type[8];
} BootSector;
#pragma pack(pop)

void read_boot_sector(const char* file_name) {
    FILE* file = fopen(file_name, "rb");
    if (!file) {
        perror("Failed to open file");
        return;
    }

    BootSector boot_sector;
    size_t read_size = fread(&boot_sector, sizeof(BootSector), 1, file);
    if (read_size != 1) {
        perror("Failed to read boot sector");
        fclose(file);
        return;
    }

    fclose(file);

    printf("OEM Name: %.8s\n", boot_sector.oem);
    printf("Bytes per Sector: %u\n", boot_sector.bytes_per_sector);
    printf("Sectors per Cluster: %u\n", boot_sector.sectors_per_cluster);
    printf("Reserved Sectors: %u\n", boot_sector.reserved_sectors);
    printf("Number of FATs: %u\n", boot_sector.num_fats);
    printf("Root Directory Entries: %u\n", boot_sector.root_entries);
    printf("Total Sectors: %u\n", boot_sector.total_sectors_short);
    printf("Media Descriptor: 0x%x\n", boot_sector.media_descriptor);
    printf("Sectors per FAT: %u\n", boot_sector.fat_size_sectors);
    printf("Sectors per Track: %u\n", boot_sector.sectors_per_track);
    printf("Number of Heads: %u\n", boot_sector.num_heads);
    printf("Hidden Sectors: %u\n", boot_sector.hidden_sectors);
    printf("Volume ID: 0x%x\n", boot_sector.volume_id);
    printf("Volume Label: %.11s\n", boot_sector.volume_label);
    printf("File System Type: %.8s\n", boot_sector.fs_type);
}

int main() {
    const char* file_name = "fat12.img"; // Replace with your image file name
    read_boot_sector(file_name);
    return 0;
}