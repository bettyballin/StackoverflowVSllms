// Function to update job statuses\nfunction updateJobStatuses() {\n    $.ajax({\n        url: '/path/to/get/job/statuses', // Replace with your actual URL\n        type: 'GET',\n        dataType: 'json',\n        success: function(data) {\n            // Assuming your table has an id of 'jobTable'\n            var $table = $('#jobTable');\n            \n            // Loop through each job status returned in the response\n            $.each(data, function(index, jobStatus) {\n                // Find the row corresponding to this job (assuming each row has a data-id attribute)\n                var $row = $table.find('tr[data-job-id=' + jobStatus.jobId + ']');\n                \n                // Update the status cell in that row (assuming the status is in the second td of the row)\n                if ($row.length > 0) {\n                    $row.find('td:eq(1)').text(jobStatus.status);\n                }\n            });\n        },\n        error: function(error) {\n            console.error("Error fetching job statuses: ", error);\n        },\n        complete: function() {\n            // Schedule this function to run again after a delay\n            setTimeout(updateJobStatuses, 8000); // 8 seconds\n        }\n    });\n}\n\n// Call the update function initially to start the process\nupdateJobStatuses();