#include <stdio.h>
#include <sys/types.h>
#include <dirent.h>
#include <string.h>

int main(void) {
    DIR *d;
    struct dirent *dir;
    int count = 0; //Initialize counter to zero.

    d = opendir(".");     // open current directory
    if (d) {             //check if opened successfully
        while ((dir = readdir(d)) != NULL){   //read each entry in directory
            if((strcmp(dir->d_name,".")==0) || strcmp(dir->d_name,"..")==0 ) continue;  //Exclude '.' and '..' from counting.
             count++;    //increment counter for each file/directory found
        }
        closedir(d);           //Close the directory
        printf("There are %d files/directories in current directory.\n",count);   //print result.
    }
  return (0);
}