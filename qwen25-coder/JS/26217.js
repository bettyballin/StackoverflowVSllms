function loadMoreData(listType, pageNumber) {\n    $.getJSON(`/users/bob/tags/footag/${listType}?page=${pageNumber}`, function(data) {\n        var listHtml = '';\n        data.forEach(function(item) {\n            // Safely escape any user-generated content\n            const escapedContent = $("<div>").text(item.username).html();\n            listHtml += `<li>${escapedContent}</li>`;\n        });\n        $(`#${listType}`).append(listHtml);\n    }).fail(function() {\n        alert('Error loading data');\n    });\n}