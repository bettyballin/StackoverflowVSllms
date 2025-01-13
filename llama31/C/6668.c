#include <stdint.h>\n\nvolatile uint32_t shared_variable;\n\nvoid cpu1_write() {\n    __atomic_store_n(&shared_variable, 0x12345678, __ATOMIC_SEQ_CST);\n}\n\nvoid cpu2_write() {\n    __atomic_store_n(&shared_variable, 0x87654321, __ATOMIC_SEQ_CST);\n}