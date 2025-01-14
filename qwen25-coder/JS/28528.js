// JavaScript using jQuery to load widgets\n$(document).ready(function() {\n    // Sample widget data (could come from an API)\n    var widgets = [\n        { id: 1, content: '<h3>Widget 1</h3><p>This is the first widget.</p>' },\n        { id: 2, content: '<h3>Widget 2</h3><p>This is the second widget.</p>' }\n    ];\n\n    // Function to load widgets\n    function loadWidgets(widgetData) {\n        var container = $('#widget-container');\n        container.empty(); // Clear existing widgets\n\n        widgetData.forEach(function(widget) {\n            var widgetDiv = $('<div class="widget"></div>');\n            widgetDiv.html(widget.content);\n            container.append(widgetDiv);\n        });\n    }\n\n    // Load widgets on page load\n    loadWidgets(widgets);\n\n    // Optionally, you can add buttons or other UI elements to dynamically add/remove widgets\n});