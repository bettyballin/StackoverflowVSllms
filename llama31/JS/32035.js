function createStringProxy(str) {\n  return new Proxy(str, {\n    get(target, prop) {\n      if (typeof prop === 'number') {\n        return target.charAt(prop);\n      }\n      return target[prop];\n    }\n  });\n}\n\nconst proxy = createStringProxy("Hello");\nconsole.log(proxy[0]); // prints "H"