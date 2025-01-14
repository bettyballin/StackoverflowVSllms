function showThrobber() {\n    let throbber = $("#throbberId"); // Assuming "throbberId" is the ID of your throbber element\n    throbber.show(); // Show the throbber\n\n    const intervalId = setInterval(() => {\n        if ($("#id").html().trim() !== "") { // If content has loaded\n            clearInterval(intervalId); // Stop the interval\n            updateThrobber(throbber, true); // Update throbber to indicate completion or hide it\n        } else {\n            updateThrobber(throbber, false); // Update throbber for ongoing process\n        }\n    }, 1000); // Check every second\n\n    // Load the content and clear the div after loading\n    $("#id").load("path/to/content.html", function() {\n        setTimeout(() => { // Delay to ensure content is set before checking\n            clearInterval(intervalId);\n            updateThrobber(throbber, true);\n        }, 50); // Adjust delay as necessary\n    });\n}\n\nfunction updateThrobber(throbberElement, done) {\n    if (done) {\n        throbberElement.hide(); // Hide the throbber when done\n    } else {\n        // Example update for throbber\n        let currentText = throbberElement.text();\n        throbberElement.text(currentText === "..." ? "." : currentText + "."); // Simple spinner effect\n    }\n}\n\n// Call this function to start loading and showing the throbber\nshowThrobber();