document.getElementById('yourContainerId').addEventListener('mousemove', function(event) {\n    var target = event.target || event.srcElement;\n    \n    // Check if the target is one of the elements you want to handle\n    if (target.classList.contains('yourTargetClass')) {\n        // Your logic and rendering here based on 'target'\n    }\n});