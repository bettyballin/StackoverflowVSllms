for file in *.cpp; do\n    sed -i '0,/^[ \t]*#include/ s//#include "newfile.h"\n&/' "$file"\ndone