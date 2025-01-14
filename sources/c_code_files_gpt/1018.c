// ExampleServer.c
#include <windows.h>
#include <stdio.h>
#include "Example.h"
#include <rpc.h>
#include <rpcndr.h>

void ExampleProc(long* pData)
{
    *pData += 1; // Example implementation
}

int main()
{
    RPC_STATUS status;

    status = RpcServerUseProtseqEp(
        (unsigned char *)"ncacn_ip_tcp",
        RPC_C_PROTSEQ_MAX_REQS_DEFAULT,
        (unsigned char *)"4747",
        NULL);

    if (status)
    {
        exit(status);
    }

    status = RpcServerRegisterIf2(
        Example_v1_0_s_ifspec,
        NULL,
        NULL,
        RPC_IF_ALLOW_LOCAL_ONLY,
        RPC_C_LISTEN_MAX_CALLS_DEFAULT,
        (unsigned)-1,
        NULL);

    if (status)
    {
        exit(status);
    }

    printf("Server is listening...\n");

    status = RpcServerListen(
        1,
        RPC_C_LISTEN_MAX_CALLS_DEFAULT,
        FALSE);

    if (status)
    {
        exit(status);
    }

    return 0;
}

// Memory allocation function
void __RPC_FAR * __RPC_USER midl_user_allocate(size_t len)
{
    return(malloc(len));
}

// Memory deallocation function
void __RPC_USER midl_user_free(void __RPC_FAR * ptr)
{
    free(ptr);
}