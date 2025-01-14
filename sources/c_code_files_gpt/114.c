#include <stdlib.h>

short int *mallocStuff(long int number, short int base){
    short int *array;
    int size = 1024;

    array = (short int*)calloc(1, size * sizeof(short int));
    return array;
}