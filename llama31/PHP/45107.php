public function __construct(private $changeSort) {}\n\npublic function getChangeSort(): string\n{\n    return $this->changeSort;\n}\n\npublic function setChangeSort(string $changeSort): void\n{\n    $this->changeSort = $changeSort;\n}