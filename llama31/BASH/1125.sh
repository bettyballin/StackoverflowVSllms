$ objdump -h a.out\n\na.out:     file format elf64-x86-64\n\nSections:\nIdx Name          Size      VMA               LMA               File off  Algn\n  0 .text         00000168  0000000000401000  0000000000401000  00000040  2**4\n                  CONTENTS, ALLOC, LOAD, READONLY, CODE\n  1 .data         00000000  0000000000402000  0000000000402000  00000200  2**4\n                  CONTENTS, ALLOC, LOAD, DATA\n  2 .bss          00000000  0000000000402000  0000000000402000  00000200  2**4\n                  ALLOC\n  3 .comment      0000002a  0000000000000000  0000000000000000  00000200  2**0\n                  CONTENTS, READONLY