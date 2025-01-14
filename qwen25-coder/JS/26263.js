$(document).ready(function() {\n    let isX = true;\n    \n    $('.cell').on('click', function() {\n        if (!$(this).text()) { // Only allow marking empty cells\n            $(this).text(isX ? 'X' : 'O');\n            $(this).css('color', isX ? '#ff0000' : '#0000ff'); // Red for X, Blue for O\n            checkWin();\n            isX = !isX; // Toggle player\n        }\n    });\n\n    function checkWin() {\n        const cells = $('.cell').map(function() { return $(this).text(); }).get();\n\n        const winningCombinations = [\n            [0, 1, 2], [3, 4, 5], [6, 7, 8], // Rows\n            [0, 3, 6], [1, 4, 7], [2, 5, 8], // Columns\n            [0, 4, 8], [2, 4, 6]             // Diagonals\n        ];\n\n        for (let i = 0; i < winningCombinations.length; i++) {\n            const [a, b, c] = winningCombinations[i];\n            if (cells[a] && cells[a] === cells[b] && cells[a] === cells[c]) {\n                alert(cells[a] + " wins!");\n                resetGame();\n            }\n        }\n\n        // Check for draw\n        if (!$('.cell').filter(function() { return !$(this).text(); }).length) {\n            alert("It's a draw!");\n            resetGame();\n        }\n    }\n\n    function resetGame() {\n        $('.cell').empty();\n        isX = true;\n    }\n});