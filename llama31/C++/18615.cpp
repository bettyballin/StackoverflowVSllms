void doOtherWork() {\n    const Bar& constThis = *this;\n    constThis.getProcess().doSomeWork();\n}