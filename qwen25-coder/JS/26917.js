// Debounce function\nfunction debounce(func, wait) {\n    let timeout;\n    return function(...args) {\n        const context = this;\n        clearTimeout(timeout);\n        timeout = setTimeout(() => func.apply(context, args), wait);\n    };\n}\n\n// Data change handler with debouncing\nconst handleInputChange = debounce(function(event) {\n    // Update local cache of data here\n    updateLocalCache(event.target.id, event.target.value);\n\n    // Trigger a bulk save after the user stops typing for 1 second\n}, 1000);\n\n// Function to update local cache\nfunction updateLocalCache(fieldId, value) {\n    formData[fieldId] = value;\n}\n\n// Bulk save function\nasync function saveFormData() {\n    try {\n        await axios.post('/api/save', formData);\n        // Reset changes after successful save\n        lastSavedData = { ...formData };\n        console.log('Data saved successfully!', formData);\n    } catch (error) {\n        handleSaveError(error, formData);\n    }\n}\n\n// Event listener for form fields\ndocument.querySelectorAll('.form-input').forEach(input => {\n    input.addEventListener('blur', handleInputChange);\n});\n\n// Variable to keep track of the last saved state\nlet lastSavedData = {};\nlet formData = {};\n\n// Example function to handle errors during save\nfunction handleSaveError(error, data) {\n    console.error('An error occurred while saving:', error);\n\n    // Optionally, prompt the user or retry with a delay\n}