#include <windows.h>
#include <wincrypt.h>

int main() {
    HCERTSTORE hRootCertStore = CertOpenSystemStore(NULL, "ROOT");
    // You should check the return value of CertOpenSystemStore
    // and close the store when you're done with it using CertCloseStore

    if (hRootCertStore) {
        // Use the store...
        CertCloseStore(hRootCertStore, 0);
    }

    return 0;
}