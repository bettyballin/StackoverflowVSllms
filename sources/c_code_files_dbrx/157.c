// c_stuff.h
#ifndef C_STUFF_H
#define C_STUFF_H

#ifdef __cplusplus
extern "C" { // for compiling with g++
#endif
  typedef struct {
    int k;
  } foo_t;

  extern int ret_foo(const struct foo_t* f);
#ifdef __cplusplus
} // end of the C section, now you can start writing in C++.
#endif

#endif // C_STUFF_H