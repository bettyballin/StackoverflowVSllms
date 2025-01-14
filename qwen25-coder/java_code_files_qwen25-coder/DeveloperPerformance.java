import java.lang.String;
public class DeveloperPerformance {
    private String name;
    private int codeQualityScore; // Based on reviews and static analysis
    private int productivityScore;  // Based on tasks completed vs time
    private int knowledgeContributionScore; // Based on presentations, documentation
    private int resolutionAndLearningScore; // Improvement over time in bug fixing efficiency
    private int collaborationScore;     // Feedback from peers

    public DeveloperPerformance(String name) {
        this.name = name;
    }

    public void setCodeQualityScore(int score) { this.codeQualityScore = score; }
    public void setProductivityScore(int score) { this.productivityScore = score; }
    public void setKnowledgeContributionScore(int score) { this.knowledgeContributionScore = score; }
    public void setResolutionAndLearningScore(int score) { this.resolutionAndLearningScore = score; }
    public void setCollaborationScore(int score) { this.collaborationScore = score; }

    public double calculateOverallPerformance() {
        return (codeQualityScore + productivityScore + knowledgeContributionScore +
                resolutionAndLearningScore + collaborationScore) / 5.0;
    }

	public static void main(String[] args) {
	}
}