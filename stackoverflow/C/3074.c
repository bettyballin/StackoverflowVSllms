#if defined(MODULENAME_IMPORT)\n#define EXPORTED __declspec(dllimport)\n#elif defined(MODULENAME_EXPORT)\n#define EXPORTED __declspec(dllexport)\n#endif