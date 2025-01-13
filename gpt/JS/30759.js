async function detectFileType(url) {\n  try {\n    const response = await fetch(url, {\n      method: 'HEAD'\n    });\n\n    if (!response.ok) {\n      throw new Error('Network response was not ok: ' + response.statusText);\n    }\n\n    const contentType = response.headers.get('Content-Type');\n\n    if (contentType) {\n      if (contentType.includes('application/x-shockwave-flash')) {\n        console.log('The URL points to a SWF file.');\n      } else if (contentType.includes('image/jpeg')) {\n        console.log('The URL points to a JPG file.');\n      } else {\n        console.log('The URL points to an unknown file type.');\n      }\n    } else {\n      console.log('Could not determine the Content-Type.');\n    }\n  } catch (error) {\n    console.error('There was a problem with the fetch operation:', error);\n  }\n}\n\n// Example usage:\nconst url = 'https://example.com/banner';\ndetectFileType(url);