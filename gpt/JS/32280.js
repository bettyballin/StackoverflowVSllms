// Constructor function\nfunction ArticleVote() {}\n\n// Adding a method to the prototype\nArticleVote.prototype.submitVote = function(vote) {\n    console.log("Vote submitted:", vote);\n};\n\n// Creating an instance of ArticleVote\nvar myVote = new ArticleVote();\nmyVote.submitVote('no'); // Output: Vote submitted: no