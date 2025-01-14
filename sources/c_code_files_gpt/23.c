#include <windows.h>
#include <rpc.h>

// Define your interface UUID and version here
#define INTERFACE_UUID "your-interface-uuid-here"
#define INTERFACE_VERSION 1,0

int main() {
    RPC_STATUS status;
    RPC_IF_HANDLE IfSpec = NULL; // Your interface specification

    // Register the interface
    status = RpcServerRegisterIfEx(IfSpec, NULL, NULL, RPC_IF_ALLOW_LOCAL_ONLY, RPC_C_LISTEN_MAX_CALLS_DEFAULT, NULL);
    if (status) {
        // Handle error
    }

    // Register the endpoint
    status = RpcServerUseProtseqEp((RPC_CSTR)"ncacn_np", RPC_C_PROTSEQ_MAX_REQS_DEFAULT, (RPC_CSTR)"\\pipe\\YourPipeName", NULL);
    if (status) {
        // Handle error
    }

    // Start to listen for client calls
    status = RpcServerListen(1, RPC_C_LISTEN_MAX_CALLS_DEFAULT, FALSE);
    if (status) {
        // Handle error
    }

    // Clean up code here
    return 0;
}

// RPC runtime will call this function to shut down the server
void Shutdown() {
    RpcMgmtStopServerListening(NULL);
    RpcServerUnregisterIf(NULL, NULL, FALSE);
}