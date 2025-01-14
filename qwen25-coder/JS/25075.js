function favoritesOnlineClick() {\n    $('#favoritesOnlinePopUp').toggle();\n    $('#onlineStatusPopUp').hide(); \n    if ($('#favoritesOnlinePopUp').is(':visible')) { \n        loadFavoritesOnlineListing();\n    }\n}\n\nfunction loadFavoritesOnlineListing() {\n    // Simulate AJAX call by filling content after a short delay\n    setTimeout(function() {\n        var content = '<p>Loading...</p>'; // Replace with actual AJAX content loading code\n        $('#favoritesOnlineListing').html(content);\n\n        // Simulate more dynamic content loading\n        setTimeout(function() {\n            var dynamicContent = '<div>Favorite 1</div><div>Favorite 2</div><div>Favorite 3</div>';\n            $('#favoritesOnlineListing').html(dynamicContent);\n\n            // Adjust the size of the popup to fit its contents\n            adjustPopupHeight();\n        }, 500); // Simulated delay for dynamic content loading\n    }, 100);\n}\n\nfunction adjustPopupHeight() {\n    var popUp = $('#favoritesOnlinePopUp');\n    // Trigger a reflow and resize\n    popUp.css('height', 'auto'); // Important to reset the height before measuring\n    var newHeight = popUp[0].offsetHeight; // Measure new height based on content\n    popUp.css('height', newHeight + 'px'); // Set height explicitly if needed for transitions\n}