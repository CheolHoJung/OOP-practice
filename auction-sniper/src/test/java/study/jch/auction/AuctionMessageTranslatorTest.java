package study.jch.auction;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.packet.Message;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

//@RunWith(JUnitRuleMockery.class)
public class AuctionMessageTranslatorTest {
    @Rule public final JUnitRuleMockery context = new JUnitRuleMockery();
    private final Runnable runnable = context.mock(Runnable.class);

    public static final Chat UNUSED_CHAT = null;
    private final AuctionEventListener listener = context.mock(AuctionEventListener.class);
    private final AuctionMessageTranslator translator = new AuctionMessageTranslator(listener);

    @Test
    void notifiesAuctionClosedWhenCloseMessageReceived() {
        Message message = new Message();
        message.setBody("SQLVersion: 1.1; Event: CLOSE;");

        translator.processMessage(UNUSED_CHAT, message);
    }
}
