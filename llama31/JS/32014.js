// Select the element you want to monitor\nvar $element = $('#myButton');\n\n// Create a mutation observer\nvar observer = new MutationObserver(function(mutations) {\n  // Check if the disabled attribute has changed\n  if (mutations[0].attributeName === 'disabled') {\n    // Fire your custom event\n    $element.trigger('disabledStateChanged');\n  }\n});\n\n// Configure the observer to watch for attribute changes\nobserver.observe($element[0], {\n  attributes: true,\n  attributeFilter: ['disabled']\n});\n\n// Example event handler for your custom event\n$element.on('disabledStateChanged', function() {\n  console.log('Disabled state changed!');\n});