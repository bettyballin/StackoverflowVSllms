// Assembly Model:\npublic class Phrase\n{\n    public int PhraseId { get; private set; }\n    public string PhraseText { get; private set; }\n\n    // Private constructor to enforce creation through factory method or repository\n    private Phrase(string phraseText) \n    {\n        this.PhraseText = phraseText;\n    }\n\n    // Factory method for creating a new Phrase\n    public static Phrase CreatePhrase(string phraseText)\n    {\n        return new Phrase(phraseText);\n    }\n}\n\n// Assembly Repository (references assembly Model):\npublic interface IPhraseRepository\n{\n    Phrase SavePhrase(Phrase phrase);\n    Phrase GetPhrase(int phraseId);\n}\n\n// Assembly Services (references assemblies Model and Repository):\npublic class PhraseService\n{\n    private readonly IPhraseRepository _phraseRepository;\n\n    public PhraseService(IPhraseRepository phraseRepository)\n    {\n        _phraseRepository = phraseRepository;\n    }\n\n    public Phrase SavePhrase(string phraseText)\n    {\n        var phrase = Phrase.CreatePhrase(phraseText);\n        var savedPhrase = _phraseRepository.SavePhrase(phrase);\n\n        // do other use-case specific work, like sending emails, logging, etc.\n\n        return savedPhrase;\n    }\n}