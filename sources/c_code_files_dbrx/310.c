#include "llvm-c/Analysis.h"
#include "llvm-c/Core.h"
#include "llvm-c/ExecutionEngine.h"
#include "llvm-c/Transforms/Scalar.h"

int main() {
    // Initialize LLVM global context, module and execution engine
    LLVMInitializeNativeTarget();
    LLVMContextRef Ctx = LLVMContextCreate(); // corrected function call
    LLVMModuleRef Module = LLVMModuleCreateWithName("my_module");
    LLVMLinkInMCJIT();
    return 0;
}