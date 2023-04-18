import jsjf.User;
import jsjf.Message;

public class App {
    public static void main(String[] args) throws Exception {
        
        User user1 = new User("1234", "192.168.1.1", "foo");

        Message message1 = new Message("foobar lorem ipsum", "192.168.1.1","192.168.1.2");
        Message message2 = new Message("foobar lorem ipsum reply", "192.168.1.2","192.168.1.1");

        user1.addInboxMessage(message1);
        user1.addOutboxMessage(message2);

        System.out.println(user1.toString() + "\n\n");
        System.out.println(user1.getInboxMessage(0).toString());
        System.out.println(user1.getOutboxMessage(0).toString());
        
    }
}
