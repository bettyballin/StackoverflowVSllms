function add(a, b) {\n    return a + b;\n}\n\ntest('adds 1 + 2 to equal 3', () => {\n    expect(add(1, 2)).toBe(3);\n});