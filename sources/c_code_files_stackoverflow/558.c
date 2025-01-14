#include <stdio.h>
#include <stdlib.h>

const int MAX_SIZE = 1024;
double Utvardering(char* buf); // you need to implement this function

int main() {
    FILE* fFile = fopen("your_file.txt", "r"); // replace "your_file.txt" with your actual file name
    if (fFile == NULL) {
        printf("Error opening file\n");
        return 1;
    }

    char buf[MAX_SIZE];
    if (fgets(buf, MAX_SIZE, fFile) == NULL) {
        printf("Read error\n");
        return 1;
    }

    double Value = Utvardering(buf);
    printf("%f\n", Value); // print the value

    fclose(fFile);
    return 0;
}