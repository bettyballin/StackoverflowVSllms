#ifndef MYCLASS_C_API_H
#define MYCLASS_C_API_H

typedef struct MyClass MyClass; // Opaque type

MyClass* MyClass_new(void);
void MyClass_doSomething(MyClass* obj);
void MyClass_delete(MyClass* obj);

#endif  // MYCLASS_C_API_H