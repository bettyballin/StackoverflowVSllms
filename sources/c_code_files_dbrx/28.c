#include <oci.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    // Declare and initialize OCI environment/server handles and error handling
    OCIEnv *envhp;
    OCIServer *srvp;
    OCISession *usrp;
    OCIStmt *stmthp;
    OCIError *errhp;
    int status = 0;

    // Initiate the environment
    if (!OCIEnvInit(&envhp, OCI_OBJECT|OCI_THREADED, NULL, NULL)) {
        exit(-1);
    } else {
        OCIHandleAlloc((dvoid *) envhp, (dvoid **) &errhp, OCI_HTYPE_ERROR, 0, NULL);
        // Create a server handle from the environment handle
        if (!OCIHandleAlloc((dvoid*)envhp, (dvoid**)&srvp, OCI_HTYPE_SERVER, 0, &status)) {
            return -1;
        } else {
            OCIAttrSet((dvoid *)srvp, (ub4) OCI_HTYPE_SERVER, (text *)"servername:port/servicename", (ub4)(strlen("servername:port/servicename")), OCI_ATTR_SERVER_NAME, errhp);
            // ... rest of the code
        }
    }

    // Clean up
    OCIHandleFree((dvoid *) srvp, OCI_HTYPE_SERVER);
    OCIHandleFree((dvoid *) errhp, OCI_HTYPE_ERROR);
    OCIHandleFree((dvoid *) envhp, OCI_HTYPE_ENV);

    return 0;
}