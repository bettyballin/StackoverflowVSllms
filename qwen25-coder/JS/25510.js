$(document).ready(function() {\n    $('#submit-button').on('click', function() {\n        var scanId = insertScanIdAndGet(); // Assuming this function inserts the scan id and returns it\n        var apiCalls = [];\n\n        // Loop to create multiple jQuery.get requests\n        for (var i = 0; i < 13; i++) {\n            apiCalls.push($.get('your-api-url', { param: 'value' }, function(response) {\n                // Handle each response here, insert into your scans table and display the result\n                var score = calculateScore(response); // Assume you have a function to calculate score\n                var resultId = insertScanResult(scanId, response, score); // Insert result and get result id\n\n                // Display result with its score\n                displayResult(resultId, response, score);\n            }).fail(function() {\n                console.log('API call failed');\n            }));\n        }\n\n        // Use $.when to determine when all AJAX calls are completed\n        $.when.apply($, apiCalls).then(function() {\n            // Retrieve all results in scans table using scan_id value and total up the score\n            var totalScore = getTotalScore(scanId);\n            displayTotalScore(totalScore); // Display the total score to the user\n        }).fail(function() {\n            console.log('One or more API calls failed');\n        });\n    });\n\n    function insertScanIdAndGet() {\n        // Your code to insert scan id and return it\n        return 1; // Placeholder for actual implementation\n    }\n\n    function calculateScore(response) {\n        // Your scoring logic here\n        return 50; // Placeholder value\n    }\n\n    function insertScanResult(scanId, response, score) {\n        // Your code to insert result into scans table and return the result id\n        return 1; // Placeholder for actual implementation\n    }\n\n    function displayResult(resultId, response, score) {\n        // Your code to display result with its score\n        console.log('Displaying result: ' + resultId);\n    }\n\n    function getTotalScore(scanId) {\n        // Your code to retrieve all results in scans table and calculate total score\n        return 500; // Placeholder value\n    }\n\n    function displayTotalScore(totalScore) {\n        // Code to display the total score to the user\n        console.log('Total Score: ' + totalScore);\n    }\n});