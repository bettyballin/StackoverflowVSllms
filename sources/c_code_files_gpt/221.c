#include <windows.h>

// Define a macro for exporting functions
#ifdef __cplusplus
extern "C" {
#endif

#ifdef BUILDING_DLL
#define DLL_EXPORT __declspec(dllexport)
#else
#define DLL_EXPORT __declspec(dllimport)
#endif

// Define a dummy function for each missing export
void DummyFunction() {}

// Export the dummy functions
DLL_EXPORT void DwmExtendFrameIntoClientArea() { DummyFunction(); }
DLL_EXPORT void DwmIsCompositionEnabled() { DummyFunction(); }

#ifdef __cplusplus
}
#endif