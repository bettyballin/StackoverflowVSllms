const f = function() {};\nconsole.log(typeof f === 'function'); // true\nconsole.log(({}).toString.call(f) === '[object Function]'); // true\n\nconst boundF = f.bind(null);\nconsole.log(typeof boundF === 'function'); // true\nconsole.log(({}).toString.call(boundF) === '[object Function]'); // false\n\nconst callable = {\n  call: function() {}\n};\nconsole.log(typeof callable === 'function'); // false\nconsole.log(({}).toString.call(callable) === '[object Function]'); // false