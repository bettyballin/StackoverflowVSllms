document.addEventListener('DOMContentLoaded', function() {\n    for (var widgetId in userPositions) {\n        $('#' + widgetId).css({ top: userPositions[widgetId].top, left: userPositions[widgetId].left });\n    }\n});