#include <openslp.h>
#include <stdio.h>
#include <stdlib.h>

void mySLPErrorCallback(SLPHandle hslp, int errorcode, void* cookie) {
    printf("SLP Error: %d\n", errorcode);
}

void mySLPServiceURLCallback(SLPHandle hslp, const char* srvurl, unsigned short lifetime, SLPError errcode, void* cookie) {
    printf("Service URL: %s\n", srvurl);
}

int main() {
    SLPError err;
    SLPHandle hslp;

    // Initialize SLP
    err = SLPOpen("en", SLP_FALSE, &hslp);
    if (err != SLP_OK) {
        printf("SLPOpen error: %d\n", err);
        return 1;
    }

    // Register a service
    err = SLPReg(hslp, "service:test:myservice://localhost", SLP_LIFETIME_DEFAULT, "serviceType=test", "", SLP_TRUE, mySLPErrorCallback, NULL);
    if (err != SLP_OK) {
        printf("SLPReg error: %d\n", err);
        SLPClose(hslp);
        return 1;
    }

    // Find the service
    err = SLPFindSrvs(hslp, "service:test:myservice", "", "", mySLPServiceURLCallback, NULL);
    if (err != SLP_OK) {
        printf("SLPFindSrvs error: %d\n", err);
        SLPClose(hslp);
        return 1;
    }

    // Close SLP
    SLPClose(hslp);
    
    return 0;
}