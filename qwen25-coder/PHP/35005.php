<?php\n// rotate.php pseudo code\n$imagePath = getImagePath(); // Your function to get the path of the next image\n\necho '<div style="position: relative; width: [width]px; height: [height]px;';\necho 'filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(src=\'' . $imagePath . '\', sizingMethod=\'scale\');">';\necho '</div>';\n?>