#include <stdio.h>
#include <stdlib.h>
#include <oci.h>

int main() {
    // Define the number of rows you want to fetch in one go.
    ub4 numRows = 1000;
    int *fetchDataArr = (int *) calloc(numRows, sizeof(int));
    OCIDefine *defnpArray[3];

    // Initialize the OCI environment
    OCIEnv *env;
    OCIError *err;
    OCISession *sess;
    OCIStmt *stmt;

    if (OCIEnvCreate((OCIEnv **) &env, OCI_DEFAULT, NULL, NULL, NULL, NULL, 0, NULL) != OCI_SUCCESS) {
        printf("Failed to create OCI environment\n");
        return 1;
    }

    if (OCIHandleAlloc(env, (void **) &err, sizeof(OCIError), OCI_HTYPE_ERROR) != OCI_SUCCESS) {
        printf("Failed to allocate error handle\n");
        return 1;
    }

    if (OCIHandleAlloc(env, (void **) &sess, sizeof(OCISession), OCI_HTYPE_SESSION) != OCI_SUCCESS) {
        printf("Failed to allocate session handle\n");
        return 1;
    }

    if (OCIHandleAlloc(env, (void **) &stmt, sizeof(OCIStmt), OCI_HTYPE_STMT) != OCI_SUCCESS) {
        printf("Failed to allocate statement handle\n");
        return 1;
    }

    // Allocate and initialize OCIDefine* array for your bind variables
    sword status;
    status = OCIHandleAlloc(env, (void **) defnpArray, 1, OCI_HTYPE_DEFINE);
    if (status != OCI_SUCCESS) {
        printf("Failed to allocate define handle\n");
        return 1;
    }

    OCIAttrSet((void *) defnpArray[0], OCI_HTYPE_DEFINE, (dvoid *) &fetchDataArr[0], sizeof(int), SQLT_INT, numRows * sizeof(int));

    // Replace 'stmt' with your statement handle and 'err' with the error handle.
    OCIDefineArrayOfStruct((void*) stmt, &defnpArray[0], err, (OCIParam **) defnpArray, 0, 16, (ub4 *) &numRows, &numRows);

    // Clean up
    OCIHandleFree(stmt, OCI_HTYPE_STMT);
    OCIHandleFree(sess, OCI_HTYPE_SESSION);
    OCIHandleFree(err, OCI_HTYPE_ERROR);
    OCIHandleFree(env, OCI_HTYPE_ENV);

    free(fetchDataArr);

    return 0;
}