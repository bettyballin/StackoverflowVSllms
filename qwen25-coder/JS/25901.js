// Example of updating content without refreshing entire page using AJAX\n     function updateSchedule() {\n         fetch('/api/schedule')\n             .then(response => response.json())\n             .then(data => {\n                 document.getElementById('schedule').innerHTML = data.newData;\n             })\n             .catch(error => console.error('Error fetching the schedule:', error));\n     }