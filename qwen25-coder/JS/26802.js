// Release $ from jQuery and assign it to a new name, e.g., jq\nvar jq = jQuery.noConflict();\n\n// Use the new alias instead of $\nvar div = jq("#divLeftSideModelsList");\nalert(div.html());