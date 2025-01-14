function fooCheck() {\n  // Function declaration internalFoo is hoisted to the top of fooCheck's scope\n  // You can use internalFoo() here because it has been hoisted\n\n  alert(internalFoo()); // Using internalFoo() here...\n\n  return internalFoo(); // And here, even though it has not been defined...\n\n  function internalFoo() {\n    return true;\n  } // ...until here! The actual definition is here, but it has already been hoisted.\n}\n\nfooCheck();