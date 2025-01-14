pp
#include <Windows.h>

int main() {
    // There is no direct equivalent to AfxOleGetMessageFilter() in standard C++ libraries.
    // You would need to use the Windows API directly to achieve similar functionality.
    // Here's an example of how you might disable the "Server Busy" dialog:
    OleInitialize(NULL);
    CoInitialize(NULL);
    IMessageFilter* pMessageFilter = NULL;
    CoRegisterMessageFilter(&pMessageFilter);
    // ... rest of your code ...
    CoUninitialize();
    return 0;
}