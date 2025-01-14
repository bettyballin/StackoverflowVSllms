// Assuming you want to get the element with id=3 and then find its previous sibling with class "item"\nvar targetIndex = 2; // Since ids are 1-based and we need 0-based for .eq()\nvar $items = $(".item");\nvar $previousItem = $items.eq(targetIndex).prev(".item");\n\nconsole.log($previousItem); // This will log the <div id="item2"></div> element