if ($handle = opendir($mainframe->getCfg('absolute_path') . "/images/store/")) {\n    $files = array();\n    while (false !== ($file = readdir($handle))) {\n        if ($file != "." && $file != "..") {\n            if (($file != "index.html") && ($file != "index.php") && ($file != "Thumbs.db")) {\n                $strExt = end(explode(".", $file));\n                if ($strExt == 'jpg') {\n                    $files[] = $file;\n                }\n            }\n        }\n    }\n    closedir($handle);\n    sort($files);\n    foreach ($files as $file) {\n        $Link = 'index.php?option=com_shop&task=deleteFile&file[]=' . $file;\n        $thelist .= '<tr class="row0"><td nowrap="nowrap"><a href="' . $Link . '">' . $file . '</a></td>' . "\n";\n        $thelist .= '<td align="center" class="order"><a href="' . $Link . '" title="delete"><img src="/administrator/images/publish_x.png" width="16" height="16" alt="delete"></a></td></tr>' . "\n";\n    }\n    echo $thelist;\n}