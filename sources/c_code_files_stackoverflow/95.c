#include <windows.h>
#include <atlbase.h>
#include <atlstr.h>

void foo(unsigned long ulSize, BSTR pData) {
    // Function implementation here
    printf("ulSize: %lu, pData: %s\n", ulSize, pData);
}

int main() {
    _bstr_t bstr("");
    foo(1, bstr);
    return 0;
}