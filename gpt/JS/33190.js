function resizeRectangleToFit(r, angle) {\n    const d2r = Math.PI / 180; // Degree to radian conversion constant\n    const r2d = 180 / Math.PI; // Radian to degree conversion constant\n\n    // Convert the angle to degrees and normalize it within the range [0, 360)\n    let deg = Math.abs(angle * r2d) % 360;\n\n    // Determine the effective angle for the calculations\n    let degt;\n    if (deg < 91) {\n        degt = angle;\n    } else if (deg < 181) {\n        degt = (180 - deg) * d2r;\n    } else if (deg < 271) {\n        degt = (deg - 180) * d2r;\n    } else {\n        degt = (360 - deg) * d2r;\n    }\n\n    // Calculate sine and cosine of the effective angle\n    const sint = Math.sin(degt);\n    const cost = Math.cos(degt);\n\n    // Calculate the new height and width of the rectangle\n    const h1 = r.height * r.height / (r.width * sint + r.height * cost);\n    const h2 = r.height * r.width / (r.width * cost + r.height * sint);\n    const hh = Math.min(h1, h2);\n    const ww = hh * r.width / r.height;\n\n    // Update the rectangle's dimensions and position\n    r.x += (r.width - ww) * 0.5;\n    r.y += (r.height - hh) * 0.5;\n    r.height = hh;\n    r.width = ww;\n}\n\n// Example usage:\nlet rect = { x: 0, y: 0, width: 100, height: 50 };\nlet angleInRadians = Math.PI / 4; // 45 degrees in radians\nresizeRectangleToFit(rect, angleInRadians);\n\nconsole.log(rect); // The resized rectangle fitting within the original bounds