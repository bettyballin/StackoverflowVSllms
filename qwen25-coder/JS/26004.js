function preloadImages(urls) {\n    urls.forEach(url => {\n        const img = new Image();\n        img.src = url;\n    });\n}\n\nfunction hide() {\n    document.getElementById("here").innerHTML = "hidden";\n}\n\nfunction show() {\n    let loadMe = [];\n    for (let i = 1; i < 250; i++) {\n        const aImgUrl = `http://example.com/${i}_a.png`;\n        const bImgUrl = `http://example.com/${i}_b.png`;\n        loadMe.push(aImgUrl, bImgUrl);\n    }\n    preloadImages(loadMe);\n\n    const container = document.getElementById("here");\n    container.innerHTML = '';\n    loadMe.forEach(url => {\n        const img = new Image();\n        img.src = url;\n        container.appendChild(img);\n        container.appendChild(document.createElement('br'));\n    });\n}