let myGlobalVar = "I am global";\n\nfunction showVariable() {\n    console.log(myGlobalVar); // Accessible here\n}\n\nshowVariable(); // Outputs: I am global\nconsole.log(myGlobalVar); // Also accessible here