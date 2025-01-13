// Example of a debounced function in JavaScript\n    function debounce(func, delay) {\n        let inDebounce;\n        return function() {\n            const context = this;\n            const args = arguments;\n            clearTimeout(inDebounce);\n            inDebounce = setTimeout(() => func.apply(context, args), delay);\n        };\n    }