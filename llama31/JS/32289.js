test("getPersons", function(assert) {\n  var done = assert.async();\n  getPersons(function(response) {\n    equals("boo", "Foo", "The name is valid");\n    done();\n  });\n});