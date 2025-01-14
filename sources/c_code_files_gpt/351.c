// dll.c
#ifdef BUILD_DLL
#define EXPORT __attribute__((dllexport))
#else
#define EXPORT __attribute__((dllimport))
#endif

EXPORT int __stdcall add2(int num) {
    return num + 2;
}

EXPORT int __stdcall mul(int num1, int num2) {
    return num1 * num2;
}