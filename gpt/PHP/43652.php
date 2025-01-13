use TYPO3\CMS\Frontend\ContentObject\ContentObjectRenderer;\nuse TYPO3\CMS\Core\Utility\GeneralUtility;\n\nclass MyExtensionClass {\n\n    /**\n     * @var ContentObjectRenderer\n     */\n    protected $contentObjectRenderer;\n\n    public function __construct() {\n        // Initialize the ContentObjectRenderer\n        $this->contentObjectRenderer = GeneralUtility::makeInstance(ContentObjectRenderer::class);\n    }\n\n    /**\n     * Render tt_content element by UID\n     * \n     * @param int $ttContentUid\n     * @return string\n     */\n    public function renderContentElementByUid(int $ttContentUid): string {\n        // Fetch the tt_content record\n        $ttContentRecord = $GLOBALS['TYPO3_DB']->exec_SELECTgetSingleRow(\n            '*',\n            'tt_content',\n            'uid=' . (int)$ttContentUid . ' AND deleted=0 AND hidden=0'\n        );\n\n        if ($ttContentRecord) {\n            // Set the current record in the ContentObjectRenderer\n            $this->contentObjectRenderer->start($ttContentRecord, 'tt_content');\n\n            // Render the content element\n            return $this->contentObjectRenderer->cObjGetSingle(\n                $ttContentRecord['CType'],\n                $ttContentRecord\n            );\n        }\n\n        return '';\n    }\n}