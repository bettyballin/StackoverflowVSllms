// Example using HTML5 Draggable API\ndocument.addEventListener('DOMContentLoaded', (event) => {\n    let dragged;\n\n    document.querySelectorAll('.portlet').forEach(item => {\n        item.addEventListener('dragstart', e => {\n            // Store a reference to the dragged element\n            dragged = e.target;\n            e.dataTransferEffectAllowed = 'move';\n            e.dataTransfer.setData('text/html', null);\n        }, false);\n\n        item.addEventListener('drop', function(e) {\n            if (e.stopPropagation) {\n                e.stopPropagation(); // Stops some browsers from redirecting.\n            }\n\n            // Move dragged elem to the target element\n            if (dragged !== this) {\n                dragged.parentNode.removeChild(dragged);\n                this.parentNode.insertBefore(dragged, this.nextSibling);\n            \n                // Send new position to server\n                updatePortletPositions();\n            }\n        }, false);\n\n        item.addEventListener('dragover', e => {\n            e.preventDefault(); // Allows us to "drop".\n            e.dataTransfer.dropEffect = 'move';\n        }, false);\n    });\n});\n\nfunction updatePortletPositions() {\n    const positions = {};\n    document.querySelectorAll('.portlet').forEach((element, index) => {\n        positions[element.id] = index;\n    });\n\n    fetch('/update-portlet-positions', {\n        method: 'POST',\n        headers: {\n            'Content-Type': 'application/json'\n        },\n        body: JSON.stringify(positions)\n    }).then(response => response.json())\n      .then(data => console.log('Success:', data))\n      .catch((error) => console.error('Error:', error));\n}