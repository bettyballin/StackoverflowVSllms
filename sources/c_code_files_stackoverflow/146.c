#include <windows.h>
#include <objbase.h>
#include <rpc.h>

int main() {
    SOLE_AUTHENTICATION_SERVICE sas;
    sas.dwAuthnSvc = RPC_C_AUTHN_GSS_KERBEROS;
    sas.dwAuthzSvc = RPC_C_AUTHZ_NONE;
    sas.pPrincipalName = L"myservice/mymachine";
    sas.hr = S_OK;
    CoInitializeSecurity( 0, 1, &sas, 0, RPC_C_AUTHN_LEVEL_DEFAULT,
        RPC_C_IMP_LEVEL_DEFAULT, 0, EOAC_NONE, 0 );
    return 0;
}