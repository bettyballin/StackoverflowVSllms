const element = document.querySelector('div');\nconst rect = element.getBoundingClientRect();\nconst width = rect.width;\nconst height = rect.height;\n\nconst viewportWidth = window.innerWidth;\nconst viewportHeight = window.innerHeight;\n\nconst centerX = (viewportWidth - width) / 2;\nconst centerY = (viewportHeight - height) / 2;\n\nelement.style.position = 'absolute';\nelement.style.left = `${centerX}px`;\nelement.style.top = `${centerY}px`;