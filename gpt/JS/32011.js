function isElementInViewport(el) {\n    const rect = el.getBoundingClientRect();\n    return (\n        rect.top >= 0 &&\n        rect.left >= 0 &&\n        rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) &&\n        rect.right <= (window.innerWidth || document.documentElement.clientWidth)\n    );\n}\n\n// Example usage:\nconst element = document.querySelector('#myElement');\nif (isElementInViewport(element)) {\n    console.log('Element is in the viewport!');\n} else {\n    console.log('Element is not in the viewport.');\n}