#ifdef MYLIBRARY_EXPORTS\n#define MYLIBRARY_API __declspec(dllexport)\n#else\n#define MYLIBRARY_API __declspec(dllimport)\n#endif\n\nextern "C" MYLIBRARY_API void ExampleFunction();