// foo.h\n#ifndef FOO_H\n#define FOO_H\n\nstruct libfoo;\n\nstruct libfoo* foo_init(void);\nvoid foo_finit(struct libfoo* foo);\nchar** foo_parse(struct libfoo* foo, const char* filename);\n\n#endif