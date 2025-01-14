$(document).ready(function() {\n    $('#processButton').on('click', function() {\n        // Show loading status\n        $('#status').text('Loading...');\n\n        var eventSource = new EventSource('/progress-endpoint'); // SSE endpoint\n\n        eventSource.onmessage = function(event) {\n            var data = JSON.parse(event.data);\n            $('#status').text(data.message); // Update status message\n            $('#progressBar').val(data.progress); // Update progress bar\n        };\n\n        eventSource.onerror = function(err) {\n            console.error("EventSource failed:", err);\n            eventSource.close();\n        };\n\n        // Make AJAX request to initiate the process\n        $.ajax({\n            url: '/start-process',\n            method: 'POST',\n            success: function(response) {\n                console.log('Process started:', response);\n            },\n            error: function(jqXHR, textStatus, errorThrown) {\n                $('#status').text('Error starting process.');\n            }\n        });\n    });\n});