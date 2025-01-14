function sendRequest(index) {\n    if (index >= ad_numbers.length) return; // Base case: stop recursion\n\n    var ad_number = $.trim(ad_numbers[index]);\n    \n    if (!ad_number) {\n        sendRequest(index + 1); // Skip this iteration and move to the next\n        return;\n    }\n\n    $.post('/fetch.php', { ad_number: ad_number }, function(data, textStatus) {\n        $('#log').prepend('<p>' + data + '</p>');\n        sendRequest(index + 1); // Call the same function with the next index\n    });\n}\n\n// Start the recursive requests\nsendRequest(0);