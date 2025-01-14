#include <stdio.h> // fopen(), fprintf()
#include <unistd.h> // sleep()
#include <sys/stat.h> // struct stat
#include <time.h> // time()

int main(void) {
    const char *filename = "logfile";
    int fd;
    FILE *fp;
    struct stat fileStat;
    off_t byteLen, lastByteSeen;
    time_t startTime, diffSecs;
    char tempBuffer[256]; // moved declaration here

    fp = fopen(filename, "r");
    if (!fp) {
        fprintf(stderr, "ERROR: could not open %s for read!\n", filename);
        return -1;
    }

    // check we have at least one line (for simplicity)
    if (fgets(tempBuffer, sizeof(tempBuffer), fp) == NULL) {
        fclose(fp);
        printf("Empty log file. Exiting!\n");
        return 0;
    }

    fseeko(fp, 0, SEEK_END); // to EOF
    lastByteSeen = ftello(fp);

    while (1) {
        sleep(1); // wait for a second
        stat(filename, &fileStat);
        if ((startTime = time(NULL)) == -1) {
            perror("ERROR: reading time");
            return -2;
        }
        byteLen = fileStat.st_size;

        fp = fopen(filename, "r");
        if (!fp) {
            fprintf(stderr, "WARNING: File closed/removed during watch! Attempting to reopen...\n");
            continue; // or break here depending on your use-case
        }

        fseeko(fp, lastByteSeen, SEEK_SET);
        while ((ftello(fp) < byteLen)) {
            size_t numBytesRead = fread(tempBuffer, 1, sizeof(tempBuffer) - 1, fp);
            if (numBytesRead <= 0 || feof(fp)) {
                break; // end of file
            } else {
                tempBuffer[numBytesRead] = '\x0';
                printf("%s", tempBuffer);
            }
        }
        diffSecs = time(NULL) - startTime;
        fclose(fp);
        lastByteSeen = byteLen;
    }
    return 0;
}