#include <stdio.h>
#include <stdlib.h>
#include <LLVM-C/Core.h>

enum OpcodeType {
    ADD,
    // ... add other opcodes here ...
};

LLVMValueRef handleOpcode(enum OpcodeType opcode, LLVMBuilderRef Builder, LLVMValueRef L, LLVMValueRef R) {
    switch (opcode) {
        case ADD: return LLVMBuildAdd(Builder, L, R, "addtmp");
        // ... add other opcodes here ...

        default: fprintf(stderr, "Unsupported opcode %d\n", opcode); exit(-1);
    }
}