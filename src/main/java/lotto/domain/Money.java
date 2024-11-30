package lotto.domain;

public class Money {
    private static final int TICKET_PRICE = 1000;
    private long currentMoney;
    private long usedMoney;
    private long earnedMoney;

    private Money(long currentMoney, long usedMoney, long earnedMoney) {
        this.currentMoney = currentMoney;
        this.usedMoney = usedMoney;
        this.earnedMoney = earnedMoney;
    }

    public static Money initFrom(long amount) {
        validate(amount);
        return new Money(amount, 0, 0);
    }

    public int getTicket() {
        long purchasedTicketCount = currentMoney / 1000;
        useMoney(purchasedTicketCount * TICKET_PRICE);
        return (int) purchasedTicketCount;
    }

    public void addMoneyByPrize(Prize prize, int count) {
        getMoney(prize.getPrizeMoney() * count);
    }

    public double getRateOfReturn() {
        return ((double) earnedMoney / usedMoney) * 100;
    }

    private void useMoney(long amount) {
        currentMoney -= amount;
        usedMoney += amount;
    }

    private void getMoney(long amount) {
        currentMoney += amount;
        earnedMoney += amount;
    }

    private static void validate(long amount) {
        if (amount % TICKET_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }
}
