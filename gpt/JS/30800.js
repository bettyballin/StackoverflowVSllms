function toggleClass(element, class1, class2) {\n    if (element.classList.contains(class1)) {\n        element.classList.remove(class1);\n        element.classList.add(class2);\n    } else {\n        element.classList.remove(class2);\n        element.classList.add(class1);\n    }\n\n    // Force reflow by modifying a non-visible style property\n    element.style.zIndex = (element.style.zIndex == 1) ? 0 : 1;\n}\n\n// Example usage:\ndocument.querySelector('.your-table-header-cell').addEventListener('click', function() {\n    toggleClass(this, 'sorted_asc', 'sorted_des');\n});