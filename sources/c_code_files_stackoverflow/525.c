#include <dshow.h>

int main() {
    IGraphBuilder* pGraph = NULL;

    // Initialize the COM library
    CoInitialize(NULL);

    // Create the filter graph manager and query for interfaces
    CoCreateInstance(CLSID_FilterGraph, NULL, CLSCTX_INPROC_SERVER, IID_IGraphBuilder, (void **)&pGraph);

    if (pGraph != NULL) {
        // Use the graph builder...

        // Release the graph builder
        pGraph->Release();
    }

    // Uninitialize the COM library
    CoUninitialize();

    return 0;
}