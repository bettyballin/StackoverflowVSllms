let uninitializedVar;\nlet nullVar = null;\n\nconsole.log(uninitializedVar); // undefined\nconsole.log(nullVar); // null\n\nconsole.log(typeof uninitializedVar); // undefined\nconsole.log(typeof nullVar); // object (this is a bug in JavaScript, it should be null)\n\nconsole.log(uninitializedVar === null); // false\nconsole.log(nullVar === null); // true