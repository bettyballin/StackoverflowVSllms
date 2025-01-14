function GetRecordSet(url, callback) {\n    fetch(url)\n        .then(response => {\n            if (!response.ok) {\n                throw new Error('Network response was not ok ' + response.statusText);\n            }\n            return response.json(); // assuming the response is JSON formatted\n        })\n        .then(data => {\n            callback(data);\n        })\n        .catch(error => {\n            console.error('There was a problem with the fetch operation:', error);\n        });\n}\n\nfunction fetchcomplete(data, layer) {\n    if (data && layer) {\n        // Assuming 'layer' is a DOM element or a valid identifier\n        document.getElementById(layer).innerHTML = JSON.stringify(data);\n        console.log("Data loaded successfully into layer:", layer);\n    } else {\n        console.error("Invalid data or layer provided");\n    }\n}\n\n// Example usage\nGetRecordSet('get_records.php', function(data) {\n    fetchcomplete(data, 'desiredLayerId'); // replace 'desiredLayerId' with your actual layer ID\n});