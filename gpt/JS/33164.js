<script>\nlet currentAbortController = null;\n\nupdateImages = function(imageSetId) {\n    // Abort previous image requests\n    if (currentAbortController) {\n        currentAbortController.abort();\n    }\n\n    // Create a new AbortController for the current request\n    currentAbortController = new AbortController();\n    const signal = currentAbortController.signal;\n\n    // Clear existing IMG set\n    $("#imagesDiv").empty();\n\n    // Fetch new image set with abort support\n    $.ajax({\n        url: "/GetImagesInSet",\n        type: "POST",\n        data: { imageSetId: imageSetId },\n        dataType: "html",\n        signal: signal,\n        success: function(data) {\n            // Add in new IMG set\n            $("#imagesDiv").html(data);\n        },\n        error: function(xhr, status, error) {\n            if (status !== 'abort') {\n                console.error("Error loading images:", error);\n            }\n        }\n    });\n};\n</script>