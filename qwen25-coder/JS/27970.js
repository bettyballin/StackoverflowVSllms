function validateAddress(form) {\n    const address1 = form.address1.value.trim();\n    const address2 = form.address2.value.trim(); // or any other method to compare addresses\n\n    if (normalizeAddress(address1) === normalizeAddress(address2)) {\n        alert('Duplicate address detected!');\n        return false;\n    }\n}\n\nfunction normalizeAddress(address) {\n    return address\n        .toLowerCase() // Convert to lowercase\n        .replace(/[^\w\s\/-]/g, '') // Remove special characters except slash and hyphen\n        .replace(/\s+/g, ' ') // Replace multiple spaces with a single space\n        .normalize('NFD').replace(/[\u0300-\u036f]/g, ''); // Normalize and remove accents\n}