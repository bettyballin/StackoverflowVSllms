#include <php.h>

#if COMPILE_DL_MYEXT /* compiletime check if zlib is available as shared module */
ZEND_GET_MODULE(myext)
#endif

int main() {
    return 0;
}