// assume 'q' is the search query parameter\nvar url = "/#" + encodeURIComponent("q=" + q);\nwindow.location.hash = url;