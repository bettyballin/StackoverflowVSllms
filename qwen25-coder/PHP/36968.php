if (!isset($rid)) {\n    \TYPO3\CMS\Core\Utility\GeneralUtility::devLog('No RID parameter found', 'your_extension_key', 2);\n} else {\n    \TYPO3\CMS\Core\Utility\GeneralUtility::devLog('RID is: ' . $rid, 'your_extension_key');\n}