$(document).ready(function() {\n       $('#gallery').masonry({\n           itemSelector: '.masonry-item',\n           columnWidth: '.masonry-item',\n           percentPosition: true\n       });\n\n       function loadThumbnails(page) {\n           $.ajax({\n               url: 'path/to/your/api',\n               data: { page: page },\n               success: function(data) {\n                   var items = '';\n                   $.each(data.thumbnails, function(index, thumbnail) {\n                       items += '<div class="masonry-item"><img class="lazy" data-src="' + thumbnail.url + '" alt=""></div>';\n                   });\n                   var $items = $(items);\n                   $('#gallery').append($items).masonry('appended', $items);\n                   $items.find('.lazy').Lazy();\n               }\n           });\n       }\n\n       // Initial load\n       loadThumbnails(1);\n\n       // Load more thumbnails on scroll\n       var page = 2;\n       $(window).scroll(function() {\n           if ($(window).scrollTop() + $(window).height() >= $(document).height() - 100) {\n               loadThumbnails(page);\n               page++;\n           }\n       });\n   });