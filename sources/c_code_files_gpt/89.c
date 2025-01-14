#include <stdint.h>
#include <stdio.h>

// Original code
typedef struct {
    int16_t leftChannel;
    int16_t rightChannel;
} PcmSample;

typedef struct {
    PcmSample* samples;
    size_t sampleCount;
    int sampleRate;
    int bitsPerSample;
    int numChannels;
} PcmBuffer;

int main() {
    // Example usage
    PcmSample sample;
    sample.leftChannel = 0x1234;
    sample.rightChannel = 0x5678;

    PcmBuffer buffer;
    buffer.samples = &sample; // Assign the address of sample to buffer.samples
    buffer.sampleCount = 1;
    buffer.sampleRate = 44100; // Typical sample rate for CD quality audio
    buffer.bitsPerSample = 16; // 16 bits per sample for PCM
    buffer.numChannels = 2; // Stereo audio

    printf("Sample Left Channel: %x\n", buffer.samples->leftChannel);
    printf("Sample Right Channel: %x\n", buffer.samples->rightChannel);
    printf("Buffer Sample Count: %zu\n", buffer.sampleCount);
    printf("Buffer Sample Rate: %d\n", buffer.sampleRate);
    printf("Buffer Bits Per Sample: %d\n", buffer.bitsPerSample);
    printf("Buffer Number of Channels: %d\n", buffer.numChannels);

    return 0;
}