const elements = document.querySelectorAll('[dir="rtl"]');\n\nelements.forEach((element) => {\n  element.style.direction = 'rtl';\n  element.style.overflow = 'auto';\n  element.style.paddingLeft = '20px'; // Make space for the scrollbar\n});