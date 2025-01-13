function addLineBreaks(paragraphElement) {\n    // Wrap each word in a span\n    var text = paragraphElement.innerHTML.replace(/ /g, '</span> <span>');\n    text = "<span>" + text + "</span>"; // Wrap first and last words\n    paragraphElement.innerHTML = text;\n  \n    // Get all the word spans\n    var spans = paragraphElement.querySelectorAll('span');\n  \n    var lastY = spans[0].getBoundingClientRect().top;\n    for (var i = 1; i < spans.length; i++) {\n        // Get the current Y position of the span\n        var currentY = spans[i].getBoundingClientRect().top;\n      \n        if (currentY !== lastY) {\n            // If Y position changes, insert a <br> before the current span\n            spans[i].insertAdjacentHTML('beforebegin', '<br />');\n        }\n      \n        // Update the lastY to the currentY\n        lastY = currentY;\n    }\n}\n\n// Example usage: pass the paragraph element to the function\nvar paragraphElement = document.querySelector('p');\naddLineBreaks(paragraphElement);