// Example function to save state with debouncing\n   function debounce(func, wait) {\n       let timeout;\n       return function(...args) {\n           clearTimeout(timeout);\n           timeout = setTimeout(() => func.apply(this, args), wait);\n       };\n   }\n\n   const saveStateDebounced = debounce(function () {\n       fetch('/saveState', {\n           method: 'POST',\n           headers: {\n               'Content-Type': 'application/json'\n           },\n           body: JSON.stringify({\n               gridState: YOUR_GRID_INSTANCE.getState() // Adjust this line to properly reference your grid instance and its state\n           })\n       }).then(response => {\n           console.log('Data sent successfully:', response);\n       }).catch(error => {\n           console.error('Failed to send data:', error);\n       });\n   }, 3000); // Save every 3 seconds\n\n   YOUR_GRID_INSTANCE.on({\n       sortchange: saveStateDebounced,\n       filterchange: saveStateDebounced\n   });