#ifndef FOO_H
#define FOO_H

struct libfoo;

struct libfoo* foo_init(void);
void foo_finit(struct libfoo* foo);
char** foo_parse(struct libfoo* foo, const char* filename);

#endif