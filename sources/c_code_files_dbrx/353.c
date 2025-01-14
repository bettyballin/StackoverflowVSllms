#include <windows.h>
#include <setupapi.h>
#include <hidsdi.h>
#include <stdio.h>

int main() {
    // Assuming hHandle is a valid handle obtained from somewhere.
    // For demonstration, let's assume it's been properly initialized.
    HANDLE hHandle = /* Initialize your handle here */;
    
    USHORT DescriptorSize = 0;
    PVOID ReportDescriptor;

    if (!HidD_GetPreparsedData(hHandle, (PHIDP_PREPARSED_DATA*) &ReportDescriptor, &DescriptorSize)) {
        printf("Error in getting the report descriptor size!!\n");
    }

    // Don't forget to free the ReportDescriptor if it was successfully obtained
    if (ReportDescriptor != NULL) {
        HidD_FreePreparsedData((PHIDP_PREPARSED_DATA) ReportDescriptor);
    }

    return 0;
}