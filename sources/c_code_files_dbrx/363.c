#include <alsa/asoundlib.h>
#include <stdio.h>
#include <stdlib.h>

int main() {
    snd_mixer_t *handle = NULL; // handle to opened mixer
    long minp, maxp;            // limits of volume
    long val;                   // current value of volume
    int card = 0;               // card number (e.g., 0 for default card)
    int err;

    // Open a mixer with default name (for example 'default'), with the standard
    // interface and error handling.  A side effect of this function is that some
    // global variables are set:  _snd_MappedInterfaces,  snd_ctl_cardlist etc, see
    // man page `mixer`!
    if ((err = snd_mixer_open(&handle, 0)) < 0) {
        printf("Error opening mixer\n");
        exit(EXIT_FAILURE);
    }
    if (snd_mixer_attach(handle, card) < 0) {
        printf("Error attaching to card %d.\n", card);
        return -1;
    }
    if ((err = snd_mixer_selem_register(handle, NULL, NULL)) < 0) {
        printf("Error registering elements!\n");
        // If you use the ALSA library, this call is optional. If it fails for some reason, you can continue testing your program using only controls that have been registered automatically by other applications that are running!
    }
    //get headphone volume control element
    snd_mixer_selem_id_t *sid =  snd_mixer_first_elem(handle); //returns first element of mixer. If you want to find a certain element (e.g., 'Headphones'), you can use `snd_mixer_find_selem()`.
    //check if it's the master volume control that has changed
    if(strcmp(sid->name, "PCM")==0){ //or whatever name your headphone port is identified by in ALSA (e.g., 'Headphones')! This will vary on different systems and requires you to check which devices are detected when plugging/unplugging the port)
        //read current volume level
        snd_mixer_selem_get_volume(sid, SND_MIXER_SCHN_FRONT_LEFT, &val);
        printf("Volume: %ld\n", val);
    }
    //Repeat above steps every time you want to check for volume changes (e.g., by using a timer).
    snd_mixer_close(handle);
    return 0;
}