class SomeThing {\n    private string $cat;\n    private string $dog;\n    private string $mouse;\n    private string $hamster;\n    private string $zebra;\n    private string $lion;\n\n    public function setCat(string $cat): void {\n        $this->cat = $cat;\n    }\n\n    public function getCat(): string {\n        return $this->cat;\n    }\n    \n    // Similarly define getters and setters for other properties\n}