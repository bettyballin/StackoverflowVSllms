#include <stdio.h>
#include <sndfile.h>

int main(){
    SNDFILE *infile;
    SF_INFO info;
    double buffer[8192]; // Assuming a maximum of 8K samples per read/write operation

    infile = sf_open("input.mp3", SFM_READ, &info); // open input file for reading
    int numChannels = info.channels;

    printf ("Opened %s\n", sf_command(infile, SFC_GET_FORMAT_INFO, NULL, NULL) );
    if(info.error != 0){
        fprintf(stderr, "Error : %s\n",sf_strerror(infile) );
        sf_close (infile);
        return -1;
    }
    while((numChannels = sf_readf_double (infile, buffer, 8192)) > 0){ // Read the file and process samples in chunks of max. 8K samples each time
      /* Apply your DSP effect on 'buffer' array */
     // ... your code here ...
    }
    sf_close (infile);
    return 0;
}