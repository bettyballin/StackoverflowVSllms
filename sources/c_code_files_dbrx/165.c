#include <windows.h>
#include <oleauto.h>

int main() {
    SAFEARRAY* array = NULL;

    // Initialize the COM library
    CoInitialize(NULL);

    // Create a sample SAFEARRAY
    array = SafeArrayCreateVector(VT_I4, 0, 10);

    // Use the SAFEARRAY as needed...

    // Cleanup the array
    SafeArrayDestroy(array);

    // Uninitialize the COM library
    CoUninitialize();

    return 0;
}