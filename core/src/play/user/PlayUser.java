package play.user;

import play.network.NetworkManager;

public class PlayUser {
    private final String userId;
    private final String userLoginName;
    private final String userLoginEmail;
    private final String userDisplayName;

    public PlayUser(String userId) {
        this.userId = userId;
        this.userLoginName = GetUserField(userId, "UserLoginName");
        this.userLoginEmail = GetUserField(userId, "UserLoginEmail");
        this.userDisplayName = GetUserField(userId, "UserDisplayName");
    }

    public PlayUser(boolean offlineMode) {
        this.userId = "null";
        this.userLoginName = "null";
        this.userLoginEmail = "null";
        this.userDisplayName = "null";
    }

    private String GetUserField(String userId, String userField) {
        try {
            return NetworkManager.SendRequest("https://pardodevelopers.altervista.org/api/v1/user?token=" + userId + "&parameter=" + userField);
        } catch (Exception e) {
            return "";
        }
    }

    public String getUserId() {
        return userId;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public String getUserLoginEmail() {
        return userLoginEmail;
    }

    public String getUserDisplayName() {
        return userDisplayName;
    }
}
