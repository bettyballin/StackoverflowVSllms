#ifdef _MSC_VER
#include <sal.h>
#else
#define __checkReturn_opt_
#define __out_ecount(size)
#define __in_z
#endif

#define _Pre_count_(size) __checkReturn_opt_ size != 0 ? __out_ecount(size): NULL
#define _In_z_       __in_z // For annotating input strings, use this macro instead of _In_z_.