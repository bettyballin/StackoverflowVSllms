var arr = [];\nfor (var i = 0; i < 10000; i++) {\n  arr[i * 1000] = i; // create sparse array with 1000 empty slots\n}\nconsole.log(performance.memory.usedJSHeapSize);