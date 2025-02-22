package online_shoppin_system;

public class UserSession implements Runnable {
    private User user;

    public UserSession(User user) {
        this.user = user;
    }

    @Override
    public void run() {
        System.out.println("User " + user.getUsername() + " session started...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("User session interrupted.");
        }
        System.out.println("User " + user.getUsername() + " session ended.");
    }
}
