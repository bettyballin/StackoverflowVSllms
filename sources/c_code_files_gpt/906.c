/* Linker script for STR710FZ2T6 */

/* Define memory regions */
MEMORY
{
    FLASH (rx) : ORIGIN = 0x40000000, LENGTH = 256K
    RAM (rwx) : ORIGIN = 0x20000000, LENGTH = 64K
}

/* Define the entry point for the application */
ENTRY(Reset_Handler)

/* Define sections */
SECTIONS
{
    /* Place the .text section in FLASH */
    .text :
    {
        KEEP(*(.isr_vector)) /* Interrupt vectors */
        *(.text*)            /* Code */
        *(.rodata*)          /* Read-only data */
        _etext = .;          /* End of text section */
    } > FLASH

    /* Place the .data section in RAM */
    .data : AT (ADDR(.text) + SIZEOF(.text))
    {
        _sdata = .;          /* Start of data section */
        *(.data*)            /* Initialized data */
        _edata = .;          /* End of data section */
    } > RAM

    /* Place the .bss section in RAM */
    .bss :
    {
        _sbss = .;           /* Start of BSS section */
        *(.bss*)             /* Uninitialized data */
        *(COMMON)
        _ebss = .;           /* End of BSS section */
    } > RAM

    /* Define end of RAM */
    _end = _ebss;
}

/* Define symbols for stack */
_estack = ORIGIN(RAM) + LENGTH(RAM);