var segment1 = "some regex segment";\nvar segment2 = "another segment";\nvar pattern = new RegExp(segment1 + segment2);\n\n// Example usage\nvar testString = "some regex segmentanother segment";\nconsole.log(pattern.test(testString)); // true