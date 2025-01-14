<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>\n<script type="text/javascript">\n    $(document).ready(function() {\n        function loadGridViewData() {\n            $.ajax({\n                url: '/YourController/GetGridViewData', // Adjust URL as needed\n                method: 'GET',\n                dataType: 'json'\n            }).done(function(data) {\n                var tbody = $('#gridView tbody');\n                tbody.empty();\n                data.forEach(function(item) {\n                    var row = $('<tr>');\n                    row.append($('<td>').text(item.Id));\n                    row.append($('<td>').text(item.Name));\n                    // Add more columns as needed\n                    tbody.append(row);\n                });\n            }).fail(function() {\n                alert('Error loading data');\n            });\n        }\n\n        // Load data on page load\n        loadGridViewData();\n\n        // Example: Reload data every minute or based on user actions\n        setInterval(loadGridViewData, 60000);\n    });\n</script>