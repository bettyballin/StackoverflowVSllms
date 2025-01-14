#include <string.h>

void swap(char* str, int i, int j){
    char t = str[i];
    str[i] = str[j];
    str[j] = t;
}

void reverse_string(char* str, int length){
    for(int i=0; i<length/2; i++){
        swap(str, i, length-i-1);
    }
}

void reverse_words(char* str){
    int l = strlen(str);
    //Reverse string
    reverse_string(str,strlen(str));
    int p=0;
    //Find word boundaries and reverse word by word
    for(int i=0; i<l; i++){
        if(str[i] == ' '){
            reverse_string(&str[p], i-p);
            p=i+1;
        }
    }
    //Finally reverse the last word.
    reverse_string(&str[p], l-p);
}

int main() {
    char str[] = "Hello World";
    reverse_words(str);
    printf("%s\n", str);
    return 0;
}