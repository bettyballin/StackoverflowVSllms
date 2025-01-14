// Define the stack\nstack = []\n\n// Stack manipulation primitives\ndef PUSH(value):\n    stack.append(value)\n\ndef POP():\n    if len(stack) == 0:\n        raise Exception("Stack underflow")\n    return stack.pop()\n\ndef DUP():\n    if len(stack) == 0:\n        raise Exception("Stack underflow")\n    stack.append(stack[-1])\n\ndef DROP():\n    if len(stack) == 0:\n        raise Exception("Stack underflow")\n    stack.pop()\n\ndef SWAP():\n    if len(stack) < 2:\n        raise Exception("Stack underflow")\n    stack[-1], stack[-2] = stack[-2], stack[-1]\n\ndef OVER():\n    if len(stack) < 2:\n        raise Exception("Stack underflow")\n    stack.append(stack[-2])\n\n// Memory access primitives\nmemory = {}\n\ndef FETCH(address):\n    if address not in memory:\n        raise Exception("Invalid memory address")\n    return memory[address]\n\ndef STORE(address, value):\n    memory[address] = value\n\n// Arithmetic primitives\ndef ADD():\n    b = POP()\n    a = POP()\n    PUSH(a + b)\n\ndef SUBTRACT():\n    b = POP()\n    a = POP()\n    PUSH(a - b)\n\ndef MULTIPLY():\n    b = POP()\n    a = POP()\n    PUSH(a * b)\n\ndef DIVIDE():\n    b = POP()\n    a = POP()\n    if b == 0:\n        raise Exception("Division by zero")\n    PUSH(a / b)\n\n// Control flow primitives\ndef BRANCH(address):\n    # Implementation of unconditional jump to address\n    pass\n\ndef BRANCH_IF_ZERO(address):\n    # Implementation of conditional jump to address if top of stack is zero\n    pass\n\ndef CALL(address):\n    # Implementation of subroutine call\n    pass\n\ndef RETURN():\n    # Implementation of subroutine return\n    pass\n\n// Input/Output primitives\ndef EMIT(character):\n    print(character, end='')\n\ndef KEY():\n    return input()