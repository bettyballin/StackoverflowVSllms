// This script in parent can still try to access iframe, but will be restricted by SOP if originally cross-origin content.\ntry {\n    let iframeDoc = document.querySelector('iframe').contentDocument;\n    console.log(iframeDoc.body); // This will likely fail due to SOP.\n} catch (e) {\n    console.error("Access denied due to Same-Origin Policy", e);\n}