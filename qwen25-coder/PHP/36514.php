<?php if (isset($_GET['action']) && $_GET['action'] != 'reply') { ?>\n    <div class="actions">\n        <input type="button" onclick="javascript: document.location='?threadID=<?=$threadID?>&action=reply';" value="Post reply" class="btn" />\n    </div>\n<?php } ?>