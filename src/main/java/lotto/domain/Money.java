package lotto.domain;

public class Money {
    private static final int TICKET_PRICE = 1000;
    private int currentMoney;
    private int usedMoney;
    private int earnedMoney;

    private Money(int currentMoney, int usedMoney, int earnedMoney) {
        this.currentMoney = currentMoney;
        this.usedMoney = usedMoney;
        this.earnedMoney = earnedMoney;
    }

    public static Money initFrom(int amount) {
        validate(amount);
        return new Money(amount, 0, 0);
    }

    public int getTicket() {
        int purchasedTicketCount = currentMoney / 1000;
        useMoney(purchasedTicketCount * TICKET_PRICE);
        return purchasedTicketCount;
    }

//    public void earnedLotto(Prize prize) {
//        earnedMoney += prize.getMoney();
//    }

    private void useMoney(int amount) {
        currentMoney -= amount;
        usedMoney += amount;
    }

    private static void validate(int amount) {
        if (amount % TICKET_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] ...");
        }
    }
}
