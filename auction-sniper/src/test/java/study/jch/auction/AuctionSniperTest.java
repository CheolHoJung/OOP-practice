package study.jch.auction;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class AuctionSniperTest {

    @Rule
    public final JUnitRuleMockery context = new JUnitRuleMockery();
    private final SniperListener sniperListener = context.mock(SniperListener.class);
    private final Auction auction = context.mock(Auction.class);
    private final AuctionSniper sniper = new AuctionSniper(auction, sniperListener);

    @Test
    public void reportsLostWhenAuctionClosed() {
        context.checking(new Expectations() {{
            oneOf(sniperListener).sniperLost();
        }});

        sniper.auctionClosed();
    }
}
