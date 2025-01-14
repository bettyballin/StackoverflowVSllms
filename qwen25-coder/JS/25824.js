function asyncStepOne() {\n    return new Promise((resolve) => {\n        setTimeout(() => { // Simulate async operation\n            console.log("Step one done");\n            resolve();\n        }, 30000); // 30 seconds\n    });\n}\n\nasync function performSteps() {\n    await asyncStepOne(); // Wait for step one to complete\n    console.log("Step two done");\n}\n\nperformSteps();