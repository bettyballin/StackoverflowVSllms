#include <stdio.h>
#include <oci.h>

int main() {
    OCIEnv *envhp;
    OCIError *errhp;
    OCILobLocator *lob_loc;
    sb4 errcode;
    char errbuf[1024];

    // Initialize the OCI environment and error handle
    if (OCIEnvCreate((OCIEnv **)&envhp, OCI_DEFAULT, NULL, NULL, NULL, NULL, 0, NULL) != OCI_SUCCESS) {
        fprintf(stderr, "OCIEnvCreate failed\n");
        return 1;
    }

    if (OCIHandleAlloc(envhp, (dvoid **)&errhp, OCI_HTYPE_ERROR, 0, NULL) != OCI_SUCCESS) {
        fprintf(stderr, "OCIHandleAlloc failed\n");
        return 1;
    }

    // Assume lob_loc is already initialized and valid
    sword status = OCILobTrim(envhp, errhp, lob_loc, 0);
    if (status != OCI_SUCCESS) {
        // Handle the error
        OCIErrorGet(errhp, 1, NULL, &errcode, errbuf, sizeof(errbuf), OCI_HTYPE_ERROR);
        fprintf(stderr, "OCILobTrim failed: %s\n", errbuf);
    }

    // Clean up
    OCIHandleFree(errhp, OCI_HTYPE_ERROR);
    OCIHandleFree(envhp, OCI_HTYPE_ENV);

    return 0;
}