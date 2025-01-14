#include <pbc/pbc.h>
#include <pbc/pbc_test.h>

int main(int argc, char **argv) {
    pairing_t pairing;
    element_t g, public_key, private_key, id, ciphertext, plaintext;
    
    pbc_demo_pairing_init(pairing, argc, argv);
    
    element_init_G1(g, pairing);
    element_init_G1(public_key, pairing);
    element_init_G1(private_key, pairing);
    element_init_G1(ciphertext, pairing);
    element_init_G1(plaintext, pairing);
    element_init_Zr(id, pairing);
    
    // Generate system parameters and master key
    element_random(g);
    element_random(public_key);
    
    // Derive private key for a given id
    element_from_hash(id, "user@example.com", strlen("user@example.com"));
    element_pow_zn(private_key, g, id);
    
    // Encrypt a message
    element_random(plaintext);
    element_pow_zn(ciphertext, public_key, id);
    element_mul(ciphertext, plaintext, ciphertext);
    
    // Decrypt the message
    element_pow_zn(plaintext, ciphertext, private_key);
    
    element_clear(g);
    element_clear(public_key);
    element_clear(private_key);
    element_clear(ciphertext);
    element_clear(plaintext);
    element_clear(id);
    pairing_clear(pairing);
    
    return 0;
}