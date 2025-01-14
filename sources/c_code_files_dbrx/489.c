#include <stdio.h>
#include <iconv.h>
#include <stdlib.h> // Added for exit function

#define MAX 1024 * 50  // Maximum size (set as per your need)

int main() {
    const char* encoding_in = "CP037";
    const char* encoding_out = "ASCII//TRANSLIT//IGNORE";
    FILE *fin, *fout;
    int n;
    size_t iconv_ret, inbytesleft, outbytesleft;
    char input[MAX];  // source EBCDIC buffer
    char output[MAX]; // destination ASCII buffer
    iconv_t cd;
    cd = iconv_open(encoding_out, encoding_in);
    if (cd == (iconv_t)-1) {
        perror("Failed to create CD");
        exit(-1);
    }

    fin = fopen("/path/to/source", "r"); // Open your EBCDIC input file here.
    fout = fopen("/path/to/output", "w"); // Your ASCII output file should be opened here

    if (fin && fout) {
       while (!feof(fin))  {
           memset(input, '\0', MAX);  /* make sure the strings are empty */
           memset(output,'\0',MAX);   /* make sure the strings are empty */
           inbytesleft = outbytesleft = MAX;  // initialize length to entire buffer for now.

           fgets (input, sizeof input, fin);
           iconv_ret = iconv(cd, &input, &inbytesleft, &output, &outbytesleft); // do the conversion from EBCDIC->ASCII

           if(iconv_ret==-1) {   /* Something went wrong */
               printf("Iconv failed!\n");
            } else{                       /* The strings were converted successfully. */
               fputs(output,fout);     // write to your output file here
       	    }
      }
    } else {
        perror("File open failure");
    }

   iconv_close(cd);  // close the descriptor when you're done.
   return (0);
}