#include <oci.h>

int main() {
    OCIEnv *env;
    OCIError *err;
    OCISvcCtx *svc;
    OCIStmt *stmt;

    OCIInitialize((ub4) OCI_DEFAULT, (dvoid *)0,  (dvoid * (*)(dvoid *, size_t)) 0, 
                  (dvoid * (*)(dvoid *, dvoid *, size_t))0, (void (*)(dvoid *, dvoid *)) 0 );

    OCIEnvInit( (OCIEnv **) &env, OCI_DEFAULT, (size_t) 0, (dvoid **) 0 );

    OCIHandleAlloc( (dvoid *) env, (dvoid **) &err, OCI_HTYPE_ERROR, 
                    (size_t) 0, (dvoid **) 0);

    OCILogon(env, err, &svc, (text *)"username", strlen("username"), 
             (text *)"password", strlen("password"), 
             (text *)"MYDB", strlen("MYDB"));

    // You should add error checking and handling code here

    return 0;
}