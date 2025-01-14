// This example assumes you have a string in ISO-8859-8 format and want to convert it to UTF-8 for display in a UTF-8 page.\n   let hebrewText = response.data;  // Assuming the server responds with Windows-1255 data here\n   let byteArray = Array.from(hebrewText).map(char => char.charCodeAt(0));\n   let utf8Str = new TextDecoder('windows-1255').decode(new Uint8Array(byteArray));\n\n   document.getElementById('yourElementId').innerHTML = utf8Str;