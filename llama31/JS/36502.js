var functions = {\n  foo: function() {\n    alert('foo');\n  }\n};\n\nvar test = 'foo';\n\nfunctions[test]();  // This calls foo()