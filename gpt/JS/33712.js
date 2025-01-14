function deleterec(layer, pk) {\n    const url = `get_records.php?cmd=deleterec&pk=${pk}&sid=${Math.random()}`;\n\n    fetch(url)\n        .then(response => response.text())\n        .then(data => {\n            // Assuming the response is a success message\n            if (data.includes("Record deleted successfully")) {\n                // Update the layer\n                update(layer, 'get_records.php'); // Assuming this will refresh the layer with updated data\n            } else {\n                console.error(data);\n            }\n        })\n        .catch(error => console.error('Error:', error));\n}