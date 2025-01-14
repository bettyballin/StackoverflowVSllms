// myclass.h remains the same as your original code

#ifndef MYCLASS_C_API_H
#define MYCLASS_C_API_H

#ifdef __cplusplus
extern "C" {
#endif

typedef struct MyClass MyClass;

MyClass* MyClass_new();
void MyClass_doSomething(MyClass* instance);
void MyClass_delete(MyClass* instance);

#ifdef __cplusplus
}
#endif

#endif // MYCLASS_C_API_H