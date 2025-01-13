using UnityEngine;\n\npublic class PlayerMovement : MonoBehaviour\n{\n    public float speed = 5f;\n    public float jumpForce = 5f;\n    private Rigidbody rb;\n    private CapsuleCollider capsuleCollider;\n    private bool isGrounded;\n\n    void Start()\n    {\n        rb = GetComponent<Rigidbody>();\n        capsuleCollider = GetComponent<CapsuleCollider>();\n    }\n\n    void Update()\n    {\n        Move();\n        Jump();\n    }\n\n    void Move()\n    {\n        float moveHorizontal = Input.GetAxis("Horizontal");\n        float moveVertical = Input.GetAxis("Vertical");\n\n        Vector3 movement = new Vector3(moveHorizontal, 0.0f, moveVertical);\n        rb.AddForce(movement * speed);\n    }\n\n    void Jump()\n    {\n        if (isGrounded && Input.GetButtonDown("Jump"))\n        {\n            rb.AddForce(Vector3.up * jumpForce, ForceMode.Impulse);\n        }\n    }\n\n    void OnCollisionEnter(Collision collision)\n    {\n        if (collision.gameObject.CompareTag("Ground"))\n        {\n            isGrounded = true;\n        }\n    }\n\n    void OnCollisionExit(Collision collision)\n    {\n        if (collision.gameObject.CompareTag("Ground"))\n        {\n            isGrounded = false;\n        }\n    }\n}