$(document).on('click', '.image-clickable', function() {\n    var imageUrl = $(this).data('url');\n    var extraData = "some_extra_data"; // This could be dynamically set based on requirements\n\n    $.ajax({\n        url: '/images/update',\n        type: 'POST',\n        dataType: 'json',\n        data: { image_url: imageUrl, extra_data: extraData },\n        success: function(response) {\n            // Update the image source with the new one from the response\n            $(this).attr('src', response.new_image_url);\n\n            // Update other parts of the page with strings returned by the controller\n            $('#status').text(response.status);\n            $('#info').text(response.info);\n        }.bind(this), // bind 'this' to maintain context within the success function\n        error: function() {\n            alert('An error occurred while updating the image.');\n        }\n    });\n});