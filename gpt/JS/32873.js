(function($) {\n    $.fn.quickPager = function() {\n        // Edit this\n        var pageSize = 10;\n        // Leave this\n        var selector = $(this);\n        var totalRecords = selector.length;\n        var currentPage = 1;\n        var pageCounter = 1;\n\n        selector.each(function(i){\n            if(i < pageCounter * pageSize && i >= (pageCounter - 1) * pageSize) {\n                $(this).addClass("page" + pageCounter);\n            } else {\n                $(this).addClass("page" + (pageCounter + 1));\n                pageCounter++;\n            }   \n        });\n\n        // Show/hide the appropriate regions \n        selector.hide();\n        $(".page" + currentPage).show();\n\n        // First check if there is more than one page. If so, build nav\n        if(pageCounter > 1) {\n            // Build pager navigation\n            var pageNav = "<ul class='pageNav'>";   \n            for (i = 1; i <= pageCounter; i++) {\n                if (i == 1) {\n                    pageNav += "<li class='currentPage pageNav" + i + "'><a rel='" + i + "' href='#'>Page " + i + "</a></li>";   \n                } else {\n                    pageNav += "<li class='pageNav" + i + "'><a rel='" + i + "' href='#'>Page " + i + "</a></li>";\n                }\n            }\n            pageNav += "</ul>";\n            $("#pagerContainer").append(pageNav);\n\n            // Pager navigation behaviour\n            $(".pageNav a").live("click", function() {\n                // Grab the REL attribute \n                var clickedLink = $(this).attr("rel");\n                currentPage = clickedLink;\n                // Remove current current (!) page\n                $("li.currentPage").removeClass("currentPage");\n                // Add current page highlighting\n                $(this).parent("li").addClass("currentPage");\n                // Hide and show relevant links\n                selector.hide();\n                selector.filter(".page" + clickedLink).show();\n                return false;\n            });\n        }\n    }\n})(jQuery);