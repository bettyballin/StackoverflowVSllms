#include <stdint.h>

// Define kEffectMagic
#define kEffectMagic 0x50637456 // 'VstP' in little-endian byte order

typedef int32_t VstInt32;

// Define a struct to hold the magic number
typedef struct {
    VstInt32 magic; ///< must be #kEffectMagic ('VstP')
} VstEffect;

int main() {
    VstEffect effect;
    effect.magic = kEffectMagic;
    return 0;
}