use TYPO3\CMS\Fluid\ViewHelpers\HtmlViewHelper;\n\npublic function renderTextElement($ttContentUid)\n{\n    $ttContentRecord = \TYPO3\CMS\Core\Utility\GeneralUtility::makeInstance(\TYPO3\CMS\Core\Database\ConnectionPool::class)\n        ->getConnectionForTable('tt_content')\n        ->selectByUid($ttContentUid);\n\n    if ($ttContentRecord) {\n        $bodytext = $ttContentRecord['bodytext'];\n        $htmlViewHelper = new HtmlViewHelper();\n        $renderedText = $htmlViewHelper->render('text', ['value' => $bodytext]);\n        return $renderedText;\n    }\n    return '';\n}