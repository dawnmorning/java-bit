package prob03;

public class Money {
	private int amount;
	
	/* 코드 작성 */
	public Money(int amount) {
		this.amount = amount;
	}
	public Money add(Money amounts) {
		return new Money(this.amount + amounts.amount );
	}
	public Money minus(Money amounts) {
		return new Money(this.amount - amounts.amount );
	}
	public Money multiply(Money amounts) {
		return new Money(this.amount * amounts.amount );
	}
	public Money devide(Money amounts) {
		return new Money(this.amount / amounts.amount );
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Money) {
			Money amounts = (Money) obj;
			return this.amount == amounts.amount;
		}
		return false;
	}
}
