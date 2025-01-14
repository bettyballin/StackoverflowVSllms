<script>\n$(function () {\n    // Make all elements with class 'draggable' draggable\n    $(".draggable").draggable({\n        helper: 'clone', // clone the element for dragging effect\n        cursor: 'move'\n    });\n\n    // Make the panel droppable and define what happens when an item is dropped\n    $("#dropZone").droppable({\n        accept: ".draggable",  // only accept draggable items\n        drop: function (event, ui) {\n            var droppedItemId = ui.draggable.attr('data-id');\n            // Call your server-side method to handle the event\n            $.ajax({\n                type: "POST",\n                url: "YourPage.aspx/FireGreatEvent", // adjust URL and Method name as needed\n                data: JSON.stringify({ id: droppedItemId }),\n                contentType: "application/json; charset=utf-8",\n                dataType: "json",\n                success: function (response) {\n                    // Handle response from server if necessary\n                    alert('Dropped item with ID: ' + droppedItemId);\n                },\n                error: function (error) {\n                    console.log(error.responseText);\n                }\n            });\n        }\n    });\n});\n</script>