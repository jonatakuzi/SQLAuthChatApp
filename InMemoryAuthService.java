package mchat;

import java.util.HashMap;
import java.util.Map;

public class InMemoryAuthService implements AuthService {

    private final Map<String, String> users = new HashMap<>();

    public InMemoryAuthService() {
        users.put("guest", "mchat123");
    }

    @Override
    public boolean authenticate(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }

    @Override public String getDisplayName(String username) { return username; }
    @Override public byte[] getProfileImageBytes(String username) { return null; }
}