function getDistinctClassesMatchingPattern(pattern) {\n    const classesSet = new Set();\n\n    $('*').each(function() {\n        $(this).attr('class')?.split(/\s+/).forEach(className => {\n            if (pattern.test(className)) {\n                classesSet.add(className);\n            }\n        });\n    });\n\n    return Array.from(classesSet);\n}\n\n// Usage: Get all distinct classes that start with 'my-'\nconst pattern = /^my-/;\nconst classes = getDistinctClassesMatchingPattern(pattern);\nconsole.log(classes);