// Using .bind()\n$("#myButton").bind("click", function() {\n    console.log("Button clicked using bind!");\n});\n\n// Using .live()\n$("a.offsite").live("click", function(event) {\n    event.preventDefault();\n    alert("You have tried to navigate to: " + this.href);\n});