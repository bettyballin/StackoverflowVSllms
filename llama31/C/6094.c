void foo() {\n    void (*fp)(); // function pointer declaration\n    fp = bar; // assign bar to fp\n    fp(); // call bar through fp\n}\n\nvoid bar() {\n    // definition\n}