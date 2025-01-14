async function fetchDataAndCalculate(nsname, lastIndex, nszones, nsquant) {\n    try {\n        // First AJAX call\n        const baseComplexityResponse = await $.get("selectdb.php", { 'id':nsname, 'q':'basecomplexity','table':'switchers' });\n        $('#switchtotal'+lastIndex).html(baseComplexityResponse); // Update DOM with response\n\n        // Second AJAX call using the result from the first\n        const sourcesResponse = await $.get("selectdb.php", { 'id':nsname, 'q':'sources','table':'switchers' });\n\n        // Perform calculations\n        const val1 = parseFloat($('#switchtotal'+lastIndex).html());\n        const answer = ((parseFloat(nszones) * parseFloat(sourcesResponse)) + val1) * parseFloat(nsquant);\n        \n        // Update DOM with calculated result\n        $('#switchtotal'+lastIndex).html(answer.toFixed(2));\n    } catch (error) {\n        console.error("Error fetching data:", error);\n    }\n}\n\n// Example usage:\nfetchDataAndCalculate('someId', 0, 5, 10);