// ExampleClient.c
#include <windows.h>
#include <stdio.h>
#include "Example.h"
#include <rpc.h>

int main()
{
    RPC_STATUS status;
    unsigned char* szStringBinding = NULL;

    status = RpcStringBindingCompose(
        NULL,
        (unsigned char*)"ncacn_ip_tcp",
        NULL,
        (unsigned char*)"4747",
        NULL,
        &szStringBinding);

    if (status)
    {
        exit(status);
    }

    status = RpcBindingFromStringBinding(
        szStringBinding,
        &Example_v1_0_c_ifspec);

    if (status)
    {
        exit(status);
    }

    long data = 5;
    ExampleProc(&data);
    printf("Data after RPC call: %ld\n", data);

    RpcStringFree(&szStringBinding);
    RpcBindingFree(&Example_v1_0_c_ifspec);

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