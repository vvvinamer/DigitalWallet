package conceptual.consistentHashing.utils;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CommonUtils {


    public static int getHash(String key) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(key.getBytes());
            // Take first 4 bytes to make a 32-bit int
            return ByteBuffer.wrap(digest).getInt();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getVirtualServerId(String serverId, int virtualServerNumber) {
        return serverId + "#" + virtualServerNumber;
    }
}
