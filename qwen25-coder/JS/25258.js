const obj = {}\n\njQuery(itemsFromDom).each(function() {\n  const element = jQuery(this)\n  const name = element.attr('id')\n  const value = element.attr('value')\n\n  // Use bracket notation to set the property using a variable\n  obj[name] = value\n})