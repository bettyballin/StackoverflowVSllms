#include <windows.h>

// Forward declaration of the PluginInit function pointer type
typedef void (*PluginInitFunc)();

// Load the plugin and call its initialization function
void loadPlugin(const char* pluginPath) {
    // Load the plugin DLL
    HMODULE hModule = LoadLibraryA(pluginPath);
    if (hModule) {
        // Get the address of the PluginInit function
        PluginInitFunc initFunc = (PluginInitFunc)GetProcAddress(hModule, "PluginInit");
        if (initFunc) {
            // Call the PluginInit function
            initFunc();
        } else {
            // Handle error: unable to find PluginInit function
            printf("Error: unable to find PluginInit function in %s\n", pluginPath);
        }
    } else {
        // Handle error: unable to load plugin DLL
        printf("Error: unable to load plugin DLL %s\n", pluginPath);
    }
}

int main() {
    // Load a plugin DLL
    loadPlugin("path/to/plugin.dll");
    return 0;
}