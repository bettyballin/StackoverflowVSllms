#include <stdio.h>
#include <string.h>

#define AES_KEY_LENGTH 256

int main() {
    uint8_t rkey[AES_KEY_LENGTH / 8];
    uint8_t* rkey_end = rkey + sizeof(rkey);
    uint8_t* key = (uint8_t*) "your_key_here"; // replace with your key
    uint8_t* key_end = key + strlen((char*) key);
    uint8_t* ptr;
    uint8_t* sptr;

    bzero((char*) rkey, AES_KEY_LENGTH / 8); /* Set initial key  */

    for (ptr = rkey, sptr = key; sptr < key_end; ptr++, sptr++) {
        if (ptr == rkey_end)
            ptr = rkey; /*  Just loop over tmp_key until we used all key */
        *ptr ^= (uint8_t) *sptr;
    }

    return 0;
}