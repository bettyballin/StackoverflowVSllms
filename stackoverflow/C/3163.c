171                  /**********************************************************\n172                  *   Test for a receive interrupt\n173                  **********************************************************/\n174              if ( USART_CHANNEL[ Channel ] -> CSR.rxrdy )\n  000008 F8051502      LSL       R5,R12,0x2\n  00000C ........      MOV       R7,LWRD(USART_CHANNEL)\n  000010 EA17....      ORH       R7,HWRD(USART_CHANNEL)\n  000014 EE0C0027      ADD       R7,R7,R12<<0x2\n  000018 6E0C          LD.w      R12,R7[0x0]\n  00001A ........      MOV       R6,LWRD(Serial_Receive_Queue)\n  00001E EA16....      ORH       R6,HWRD(Serial_Receive_Queue)\n  000022 785B          LD.w      R11,R12[0x14]\n  000024 A19B          LSR       R11,0x1\n  000026 C0B2          BRCC      ??USART_Process_Interrupt_1:C