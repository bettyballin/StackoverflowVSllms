string tempFile = "output_page_%d.png"; // Use %d in the filename for sequential numbering\nstring[] args ={\n    "-q",                     \n    "-dQUIET",                   \n    "-dPARANOIDSAFER", // Run this command in safe mode\n    "-dBATCH", // Keep gs from going into interactive mode\n    "-dNOPAUSE", // Do not prompt and pause for each page\n    "-dNOPROMPT", // Disable prompts for user interaction                           \n    "-dFirstPage="+start,\n    "-dLastPage="+stop,   \n    "-sDEVICE=png16m",\n    "-dTextAlphaBits=4",\n    "-dGraphicsAlphaBits=4",\n    "-r300x300",                \n    // Set the input and output files\n    String.Format("-sOutputFile={0}", tempFile),\n    originalPdfFile\n};