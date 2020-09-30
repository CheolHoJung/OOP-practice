package study.jch.auction;

public interface AuctionEventListener {
    void auctionClosed();

    void currentPrice(int price, int increment);
}
