var selectedItems = [];\nselectedItems.push("0ce49e98-a8aa-46ad-bc25-3a49d475e9d3");\nconsole.log(Array.isArray(selectedItems)); // true\n\nvar selectedItems = "0ce49e98-a8aa-46ad-bc25-3a49d475e9d3".split(",");\nconsole.log(Array.isArray(selectedItems)); // false