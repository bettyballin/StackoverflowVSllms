#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <windows.h>

typedef unsigned char BYTE;

typedef struct ShortString {
  char len;
  char data[255];
};

typedef void (__stdcall *GETCPUID)(struct ShortString *result, BYTE cpuCore);

GETCPUID pGetSerial;

int main() {
    HMODULE hWtsLib = LoadLibrary("HardwareIDExtractor.dll");
    if (hWtsLib) {
      ShortString serial;
      pGetSerial = (GETCPUID)GetProcAddress(hWtsLib, "GetCPUID");
      pGetSerial(&serial, '1');
      char *str = malloc(serial.len + 1); // include space for the trailing \0
      strncpy(str, serial.data, serial.len);
      str[serial.len] = '\0'; // drop in the trailing null
      printf("%s\n", str);
      free(str);
    }
    return 0;
}