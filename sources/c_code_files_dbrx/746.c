#include <stdio.h>
#include <stdint.h>

typedef struct {
    uint8_t  jmpBoot[3];        // bootstrap short or near jump
    char     oemName[8];         // OEM name (padded with spaces)
    uint16_t bytesPerSector;     // # of bytes per sector
    uint8_t  sectorsPerCluster;
    uint16_t reservedSectors;
    uint8_t  numberOfFATs;       // # of FAT's on the media
    uint16_t rootDirEnts;        // size of root directory (normally a multiple of bytes per sector)
    uint16_t totalSectors;       // total sectors, if zero then use numberOfSectors16, else, if zero then use numberOfSectors32
    uint8_t  mediaDescriptorType;// 0xF8 is a hard disk
                                 // 0xF0 reserved for removable media.
                                 // bit7(MSB) set: fixed disk drive (hard disk), if zero, then floppy or removable media
    uint16_t sectorsPerFAT;      // # of sectors per FAT
    uint16_t sectorsPerTrack;    // physical sector per track for interrupt 0x13
    uint16_t heads;              // # of physical heads, used with int 0x13
    uint32_t numberOfHiddenSectors;// # of hidden sectors
                                 // this is generally set to zero on floppy or removable media images.
                                 // and can be a nonzero value for hard disks (fixed media)
    uint32_t totalSectorsHuge;   // used if the field "totalSectors" had been set to 0 in the BPB structure
}__attribute__((packed)) fatHeader;

int main() {
    FILE* fp;
    fatHeader fhb;

    fp = fopen("myFatImage.img", "rb"); // open file (assuming it's named as this example) in binary mode for reading

    if(fp != NULL){
        fread(&fhb, sizeof(fatHeader), 1, fp);   //Reading the boot sector which contains FAT metadata.

        printf("BPB Structure data:\n");
        printf("Bytes Per Sector : %d \tSectors per Cluster:%d\n",fhb.bytesPerSector, fhb.sectorsPerCluster);
        // Continue reading other parts and print them accordingly (not done here as it is specific to your requirements)

        fclose(fp);  //Close the file, before exiting.
    }else{
       printf("Error opening the image!\n"); //Print error if cannot open file.
    }
    return 0;
}