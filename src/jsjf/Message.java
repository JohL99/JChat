package jsjf;

public class Message {

    private String messageBody;
    private String senderAddr;
    private String receiverAddr;

    public Message(String messageBody, String senderAddr, String receiverAddr) {
        setMessageBody(messageBody);
        setSenderAddr(senderAddr);
        setReceiverAddr(receiverAddr);
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getSenderAddr() {
        return senderAddr;
    }

    public void setSenderAddr(String senderAddr) {
        this.senderAddr = senderAddr;
    }

    public String getReceiverAddr() {
        return receiverAddr;
    }

    public void setReceiverAddr(String receiverAddr) {
        this.receiverAddr = receiverAddr;
    }

    public String toString() {

        String output = String.format("Message = [\n\tMessage Body: %s\n\tReceiver Address: %s\n\tSender Address: %s\n]",
                                            messageBody, receiverAddr, senderAddr);
        return output;

    }
    
}
