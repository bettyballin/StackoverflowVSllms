import software.amazon.awssdk.services.iam.IamClient;
import software.amazon.awssdk.services.iam.model.AttachRolePolicyRequest;

public class AttachPolicyToRoleExample {
    // Example of attaching a policy to an IAM role via AWS SDK for Java

    public static void main(String[] args) {
        IamClient iamClient = IamClient.builder().build();
        AttachRolePolicyRequest request = AttachRolePolicyRequest.builder()
            .roleName("YourEC2WorkerRole")
            .policyArn("arn:aws:iam::aws:policy/AmazonSQSFullAccess")
            .build();
        iamClient.attachRolePolicy(request);
    }
}