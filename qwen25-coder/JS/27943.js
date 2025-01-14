//function to change movie files, note SetResetPropertiesOnReload must be set to false\n//otherwise the B'stard player will default all attributes when setURL runs\n//\nfunction changemovie(newmovie) {\n    oldfile = currentfile;\n    if (newmovie == currentfile) {\n        showEvents('same file requested so no action taken');\n        return;\n    }\n\n    // Update current file and display the player div\n    currentfile = newmovie;\n    document.getElementById("player").style.display = 'block';\n    document.getElementById("noclipoverlay").style.display = 'none';\n\n    // Remove any existing QuickTime object in the player div\n    $("#player").empty();\n\n    if (!oldfile) {\n        showEvents('the old media file was blank');\n    }\n\n    // Dynamically create and append the QuickTime embed element to the player div\n    var movie1Html = QT_WriteOBJECT(\n        currentfile, playerwidth, playerheight, "",\n        "controller", "false",\n        "obj#id", "movie1",\n        "emb#id", "qt_movie1",\n        "postdomevents", "True",\n        "emb#NAME", "movie1",\n        "enablejavascript", "true",\n        "autoplay", "true",\n        "scale", "aspect",\n        "pluginspage", "http://www.apple.com/quicktime/download/"\n    );\n    \n    $("#player").html(movie1Html);\n\n    // Assuming QT_WriteOBJECT returns the HTML string, this will render it inside the player div\n\n    if (boolisplaying) {\n        document.movie1.Play();\n    }\n}