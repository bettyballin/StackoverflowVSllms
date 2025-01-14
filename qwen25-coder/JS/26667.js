function getSelectedTextFromAllFrames() {\n    let selectedText = '';\n\n    // Check the main document first\n    if (document.getSelection) {\n        selectedText = document.getSelection().toString();\n    } else if (document.selection && document.selection.createRange) {\n        selectedText = document.selection.createRange().text;\n    }\n\n    // Function to check within a given frame or iframe\n    function checkFrame(frameOrIframe) {\n        try {\n            const frameDocument = frameOrIframe.contentWindow.document;\n            let textInFrame = '';\n            if (frameDocument.getSelection) {\n                textInFrame = frameDocument.getSelection().toString();\n            } else if (frameDocument.selection && frameDocument.selection.createRange) {\n                textInFrame = frameDocument.selection.createRange().text;\n            }\n            return textInFrame.trim() !== '' ? textInFrame : null;\n        } catch (e) {\n            // Security error, cross-origin\n            return null;\n        }\n    }\n\n    // Check frames and iframes\n    const allFrames = window.frames;\n    for (let i = 0; i < allFrames.length; i++) {\n        const frameText = checkFrame(allFrames[i]);\n        if (frameText) {\n            selectedText += frameText + '\n';\n        }\n    }\n\n    // Optionally, you can dive into nested frames\n    function checkNestedFrames(node) {\n        for (let i = 0; i < node.childNodes.length; i++) {\n            const childNode = node.childNodes[i];\n            if (childNode.tagName === 'FRAME' || childNode.tagName === 'IFRAME') {\n                try {\n                    const frameText = checkFrame(childNode.contentWindow);\n                    if (frameText) {\n                        selectedText += frameText + '\n';\n                    }\n                } catch (e) {\n                    // Ignore cross-origin errors\n                }\n            }\n            checkNestedFrames(childNode); // Recurse into subframes\n        }\n    }\n\n    checkNestedFrames(document.body);\n\n    return selectedText.trim();\n}\n\nconsole.log(getSelectedTextFromAllFrames());