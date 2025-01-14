async function mySubmit(id, bigText) {\n  const url = "SubmitPost.cfm";\n  const params = new URLSearchParams({ id: id, bigtext: bigText });\n\n  try {\n    const response = await fetch(url, {\n      method: 'POST',\n      headers: {\n        'Content-Type': 'application/x-www-form-urlencoded'\n      },\n      body: params\n    });\n\n    if (!response.ok) {\n      throw new Error('Network response was not ok');\n    }\n\n    // Handle the response here\n    const result = await response.text();\n    console.log(result);\n  } catch (error) {\n    console.error('There has been a problem with your fetch operation:', error);\n  }\n}