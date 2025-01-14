// neko_vm.h
#ifndef NEKO_VM_H
#define NEKO_VM_H

#ifdef __cplusplus
#define EXTERN extern "C"
#else
#define EXTERN extern
#endif

#include <stdbool.h>

EXTERN bool neko_thread_register(bool t);

#endif // NEKO_VM_H