#include <windows.h>
#include <oaidl.h> // For VARIANT, SAFEARRAY, and related functions

// Assuming CArray is a custom class, you need to include its definition or use a standard alternative
// For demonstration, I'll use a simple array since the actual implementation of CArray isn't provided
#include <stdlib.h>

// Custom function to mimic the behavior of Array.GetSize()
size_t getArraySize(BYTE* array) {
    // This is a placeholder; actual implementation depends on your array
    // For the purpose of this example, let's assume a fixed size
    return 10; // Example size
}

bool ArrayToVariant(BYTE* array, VARIANT& vtResult) {
    SAFEARRAY FAR* psarray;
    SAFEARRAYBOUND sabounds[1];

    sabounds[0].lLbound = 0;
    sabounds[0].cElements = (ULONG)getArraySize(array);

    long nLbound;

    psarray = SafeArrayCreate(VT_UI1, 1, sabounds);
    if (psarray == NULL)
        return false;

    for (nLbound = 0; nLbound < (long)sabounds[0].cElements; nLbound++) {
        BYTE element = array[nLbound];
        if (FAILED(SafeArrayPutElement(psarray, &nLbound, &element))) {
            SafeArrayDestroy(psarray);
            return false;
        }
    }

    VariantFree(&vtResult); // Pass the address of vtResult
    vtResult.vt = VT_ARRAY | VT_UI1;
    vtResult.parray = psarray;
    return true;
}

int main() {
    // Example usage
    BYTE myArray[10] = {0}; // Initialize with actual data
    VARIANT vtResult;
    VariantInit(&vtResult); // Initialize VARIANT

    if (ArrayToVariant(myArray, vtResult)) {
        // Success, handle result
    } else {
        // Failed
    }

    // Don't forget to free resources when done
    VariantFree(&vtResult);

    return 0;
}