// script.js\nconst icons = document.querySelectorAll('.icon');\nlet draggedIcon = null;\n\nicons.forEach(icon => {\n    icon.addEventListener('dragstart', (e) => {\n        draggedIcon = e.target;\n        e.dataTransfer.effectAllowed = 'move';\n        e.dataTransfer.setData('text/html', e.target.innerHTML);\n    });\n\n    icon.addEventListener('dragover', (e) => {\n        e.preventDefault();\n        e.dataTransfer.dropEffect = 'move';\n    });\n\n    icon.addEventListener('drop', (e) => {\n        e.preventDefault();\n        if (draggedIcon && draggedIcon !== e.target) {\n            draggedIcon.innerHTML = e.target.innerHTML;\n            e.target.innerHTML = e.dataTransfer.getData('text/html');\n        }\n    });\n\n    icon.addEventListener('dragend', () => {\n        draggedIcon = null;\n    });\n});