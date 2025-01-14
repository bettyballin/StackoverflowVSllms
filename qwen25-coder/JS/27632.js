function fetchPlaylistVideos(playlistId) {\n    const maxResults = 50; // YouTube Data API v2 allows up to 50 items per page\n    let startIndex = 1;\n    let allVideos = [];\n\n    function fetchPage() {\n        const url = `https://gdata.youtube.com/feeds/api/playlists/${playlistId}?v=2&alt=jsonc&start-index=${startIndex}&max-results=${maxResults}`;\n        \n        fetch(url)\n            .then(response => response.json())\n            .then(data => {\n                if (data && data.data && data.data.items) {\n                    allVideos = allVideos.concat(data.data.items);\n                    startIndex += maxResults;\n                    \n                    // Check if there are more pages\n                    if (startIndex <= data.data.totalItems) {\n                        fetchPage();\n                    } else {\n                        console.log('All videos:', allVideos);\n                        // You can now use allVideos as needed, e.g., to embed randomly\n                        randomizeAndEmbed(allVideos);\n                    }\n                } else {\n                    console.error('No more items or invalid response:', data);\n                }\n            })\n            .catch(error => console.error('Error fetching data:', error));\n    }\n\n    fetchPage();\n}\n\nfunction randomizeAndEmbed(videos) {\n    // Shuffle the array and take 25 random videos\n    const shuffledVideos = videos.sort(() => Math.random() - 0.5).slice(0, 25);\n    console.log('Random 25 Videos:', shuffledVideos);\n    // Embed logic here\n}\n\n// Replace 'YOUR_PLAYLIST_ID' with your actual YouTube playlist ID\nfetchPlaylistVideos('YOUR_PLAYLIST_ID');