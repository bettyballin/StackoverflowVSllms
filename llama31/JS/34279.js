const callableObject = new Function('x', 'y', 'console.log(x, y)');\ncallableObject(1, 2);  // outputs: 1 2