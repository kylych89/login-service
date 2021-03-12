package us.peaksoft.loginservice.services.impl;

import org.springframework.stereotype.Service;
import us.peaksoft.loginservice.services.PasswordService;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Sayfullah on 12.03.2021.
 */
@Service
public class PasswordServiceImpl implements PasswordService {
    @Override
    public String generatePassword(String password) {
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            // Add password bytes to digest
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            // This bytes[] has bytes in decimal format:
            // Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString(bytes[i] & 0xff + 0x100, 16).substring(1));
            }
            // Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
}
