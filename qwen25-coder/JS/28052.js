const debounce = (func, wait) => {\n    let timeout;\n    return function(...args) {\n        clearTimeout(timeout);\n        timeout = setTimeout(() => func.apply(this, args), wait);\n    };\n};\n\nfunction autoSave(dataGrid, saveUrl) {\n    let lastSavedData = JSON.stringify(dataGrid.getData());\n    \n    const handleAutoSave = () => {\n        const currentData = JSON.stringify(dataGrid.getData());\n        if (currentData !== lastSavedData) {\n            fetch(saveUrl, {\n                method: 'POST',\n                headers: {\n                    'Content-Type': 'application/json'\n                },\n                body: JSON.stringify({ data: currentData })\n            }).then(response => {\n                if (!response.ok) throw new Error('Network response was not ok');\n                lastSavedData = currentData;\n            }).catch(error => console.error('There was a problem with the fetch operation:', error));\n        }\n    };\n\n    // Debounce saves to avoid excessive requests\n    const debouncedAutoSave = debounce(handleAutoSave, 2000);\n\n    dataGrid.on('change', () => debouncedAutoSave());\n    dataGrid.on('blur', () => debouncedAutoSave());\n}\n\n// Usage example:\nconst myDataGrid = ...; // Assume this is your initialized data grid object\nconst saveUrl = '/save-data'; // URL to send the data to\n\nautoSave(myDataGrid, saveUrl);