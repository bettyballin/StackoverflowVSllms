#if defined(MODULENAME_IMPORT)
#define EXPORTED __declspec(dllimport)
#elif defined(MODULENAME_EXPORT)
#define EXPORTED __declspec(dllexport)
#else
#define EXPORTED // In case neither MODULENAME_IMPORT nor MODULENAME_EXPORT is defined
#endif

// Minimal example function using the EXPORTED macro
EXPORTED void exampleFunction() {
    // Example function body
}

int main() {
    exampleFunction();
    return 0;
}