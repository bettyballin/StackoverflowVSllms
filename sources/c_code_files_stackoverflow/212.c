#include <windows.h>
#include <objbase.h>
#include <rpc.h>

int main() {
    GUID guid;
    HRESULT hr = CoCreateGuid(&guid);

    // Convert the GUID to a string
    RPC_WSTR guidStr;
    UuidToString(&guid, &guidStr);
    printf("%S\n", guidStr);
    RpcStringFree(&guidStr);
    return 0;
}