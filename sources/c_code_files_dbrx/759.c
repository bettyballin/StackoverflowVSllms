#include <stdio.h>
#include <string.h>

int main(void) {
    char tmp, arr[100];
    int i, k;

    printf("Enter a string: ");
    scanf("%99s", arr); 

     for (k = 0, i = (strlen(arr) - 1); k < (int)(strlen(arr)/2); --i, ++k) {
        tmp = arr[k];
        arr[k] = arr[i];
	    arr[i] = tmp;
     }

     puts(arr);

    return 0;
}