#include <stdio.h>
#include <stdlib.h>
#include <oci.h>

int main() {
    // Assuming fetchDataArr is a dynamically allocated array
    void* fetchDataArr = malloc(1024); // Replace 1024 with the actual size

    // Assuming defnpArray is an array of OCIDefine pointers
    OCIDefine* defnpArray[1];
    OCIEnv* env;
    OCIError* err;
    OCISvcCtx* svc;
    OCIEnvCreate((OCIEnv**)&env, OCI_DEFAULT, NULL, NULL, NULL, NULL, 0, NULL);
    OCIHandleAlloc(env, (dvoid**)&err, OCI_HTYPE_ERROR, 0, NULL);
    OCIHandleAlloc(env, (dvoid**)&svc, OCI_HTYPE_SVCCTX, 0, NULL);

    // Initialize defnpArray
    defnpArray[0] = (OCIDefine*)malloc(sizeof(OCIDefine));
    OCIHandleAlloc(env, (dvoid**)&defnpArray[0], OCI_HTYPE_DEFINE, 0, NULL);

    // Your original code
    free(fetchDataArr);
    OCIDescriptorFree((dvoid*)defnpArray[0], OCI_DTYPE_DEFINE);

    // Free resources
    OCIHandleFree(defnpArray[0], OCI_HTYPE_DEFINE);
    free(defnpArray[0]);
    OCIHandleFree(svc, OCI_HTYPE_SVCCTX);
    OCIHandleFree(err, OCI_HTYPE_ERROR);
    OCIHandleFree(env, OCI_HTYPE_ENV);

    return 0;
}