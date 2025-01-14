function mainfunc(func) {\n    // Convert arguments object to an array and slice off the first argument (the function name)\n    var argsArray = Array.prototype.slice.call(arguments, 1);\n    window[func].apply(null, argsArray);\n}\n\nfunction calledfunc1(par1, par2) {\n    console.log(par1, par2); // Do stuff here\n}\n\nfunction calledfunc2(par1, par2, par3) {\n    console.log(par1, par2, par3); // Do stuff here\n}\n\nmainfunc('calledfunc1', 'hello', 'bye');\nmainfunc('calledfunc2', 'hello', 'bye', 'goodbye');