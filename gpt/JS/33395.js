for (i = 0; i < tagsToSearch.length; i++) {\n    var ctag = jQuery.trim(currentTag.tag);\n    var regex = new RegExp(ctag, "i"); // Create a new RegExp object with the variable and ignore case\n    if (tagsToSearch[i].match(regex)) {\n        matches.push(tagsToSearch[i]);\n    }\n}