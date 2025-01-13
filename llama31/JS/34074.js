$('#thumbnails').masonry({\n  itemSelector: '.thumbnail',\n  columnWidth: 200,\n  gutter: 10,\n  lazyLoad: true\n});\n\n// Load thumbnails via AJAX when they come into view\n$('#thumbnails').on('masonry-layout', function(event, laidOutItems) {\n  $(laidOutItems).each(function() {\n    var thumbnail = $(this);\n    // Load thumbnail image via AJAX\n    $.ajax({\n      url: '/load-thumbnail',\n      data: { id: thumbnail.data('id') },\n      success: function(data) {\n        thumbnail.html('<img src="' + data + '">');\n      }\n    });\n  });\n});