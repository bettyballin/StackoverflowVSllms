#include <windows.h>
#include <hidsdi.h>
#include <stdio.h>

void Print(const char* message) {
    printf("%s\n", message);
}

int main() {
    HANDLE hHandle = NULL; // assume you have a valid handle

    PHIDP_PREPARSED_DATA PreparsedData = NULL;
    if (!HidD_GetPreparsedData(hHandle, &PreparsedData)) {
        Print("Error in getting the preparsed data!!");
        CloseHandle(hHandle);
        return 1;
    }

    // don't forget to free the preparsed data when you're done with it
    HidD_FreePreparsedData(PreparsedData);

    return 0;
}