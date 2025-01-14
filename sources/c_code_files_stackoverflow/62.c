#include <stdio.h>
#include <oci.h>

int main() {
    OCIEnv* env;
    OCISvcCtx* svc;
    OCIError* err;
    OCIHandle* hndl;
    OCIDateTime* datetime;
    OraText* date_str = (OraText*) "2022-01-01 12:00:00";

    // Initialize the OCI environment
    if (OCIEnvCreate((OCIEnv**)&env, OCI_DEFAULT, NULL, NULL, NULL, NULL, 0, NULL)) {
        printf("Failed to create OCI environment\n");
        return 1;
    }

    // Allocate the error handle
    if (OCIHandleAlloc(env, (dvoid**)&err, OCI_HTYPE_ERROR, 0, NULL)) {
        printf("Failed to allocate error handle\n");
        return 1;
    }

    // Allocate the service context handle
    if (OCIHandleAlloc(env, (dvoid**)&svc, OCI_HTYPE_SVCCTX, 0, NULL)) {
        printf("Failed to allocate service context handle\n");
        return 1;
    }

    // Allocate the datetime handle
    if (OCIHandleAlloc(env, (dvoid**)&datetime, OCI_HTYPE_DATE, 0, NULL)) {
        printf("Failed to allocate datetime handle\n");
        return 1;
    }

    // Convert the date string to an OCIDateTime object
    if (OCIDateTimeFromText(env, err, date_str, strlen((char*)date_str), NULL, NULL, OCI_DATE_TIME, datetime)) {
        printf("Failed to convert date string to OCIDateTime object\n");
        return 1;
    }

    // Print the converted datetime
    printf("Converted datetime: %04d-%02d-%02d %02d:%02d:%02d\n",
           OCIDateTimeGetYear(env, err, datetime),
           OCIDateTimeGetMonth(env, err, datetime),
           OCIDateTimeGetDay(env, err, datetime),
           OCIDateTimeGetHour(env, err, datetime),
           OCIDateTimeGetMinute(env, err, datetime),
           OCIDateTimeGetSecond(env, err, datetime));

    // Free the allocated handles
    OCIHandleFree(datetime, OCI_HTYPE_DATE);
    OCIHandleFree(svc, OCI_HTYPE_SVCCTX);
    OCIHandleFree(err, OCI_HTYPE_ERROR);
    OCIHandleFree(env, OCI_HTYPE_ENV);

    return 0;
}