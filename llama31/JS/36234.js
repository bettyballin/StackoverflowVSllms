function move() {\n  // Calculate the distance between the current and end points\n  var dx = endX - currentX;\n  var dy = endY - currentY;\n\n  // Calculate the length of the distance vector\n  var distance = Math.sqrt(dx * dx + dy * dy);\n\n  // If the distance is less than the step amount, we're close enough to the end point\n  if (distance < step_amount) {\n    currentX = endX;\n    currentY = endY;\n  } else {\n    // Calculate the normalized direction vector\n    var nx = dx / distance;\n    var ny = dy / distance;\n\n    // Update the current position based on the direction vector and step amount\n    currentX += nx * step_amount;\n    currentY += ny * step_amount;\n  }\n\n  // Update the image position using the current coordinates\n  // (assuming you have a function to update the image position)\n\n  // Request the next animation frame\n  requestAnimationFrame(move);\n}