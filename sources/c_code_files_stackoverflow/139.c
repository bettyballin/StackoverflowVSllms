// mylib.h
#ifndef MYLIB_H
#define MYLIB_H

#ifdef LIBRARY_EXPORTS
#    define LIBRARY_API __attribute__((visibility("default")))
#else
#    define LIBRARY_API
#endif

LIBRARY_API void my_function(void);

#endif  // MYLIB_H