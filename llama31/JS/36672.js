// Assume you have an audio element in your HTML\n<audio id="soundPlayer" preload="auto"></audio>\n\n// On word click, load and play the corresponding sound file\n$(".word").on("click", function() {\n    var word = $(this).text();\n    var soundFileUrl = "/Sounds/" + word + ".mp3"; // adjust URL accordingly\n\n    // Load sound file via AJAX\n    $.ajax({\n        url: soundFileUrl,\n        type: "GET",\n        success: function(data) {\n            // Play the sound file\n            $("#soundPlayer").attr("src", soundFileUrl);\n            $("#soundPlayer")[0].play();\n        }\n    });\n});