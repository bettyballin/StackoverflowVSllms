#include <stdio.h>
#include <string.h>
#include <zlib.h>
#include <stdlib.h>

int main() {
    //****************************************************************************************
    //ZIP file: Take the char string "outputFile" as input to gzip. Create a zipped html file
    gzFile file;
    char outputFile[] = "Your output file content here"; // Define outputFile
    file = gzopen("..\\index.html.gz", "wb"); //create a zipped file
    if (file == NULL) {
        printf("Can't open zipped file");
        exit(1);
    }
    int len   = strlen(outputFile); //need to know length of string
    int compd = gzwrite(file, outputFile, (unsigned)len); //compress data into .gz file
    int cls   = gzclose (file); //close .gz file
    //End zip***********************************************************************************
    return 0;
}