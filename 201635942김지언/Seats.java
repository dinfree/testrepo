package javabasic.train;

public class Seats {
		private SeatType seatType;
		private int price;
		
		public Seats(SeatType seatType, int price) {
			this.setSeatType(seatType);
			this.setPrice(price);
		}

		public SeatType getSeatType() {
			return seatType;
		}

		public void setSeatType(SeatType seatType) {
			this.seatType = seatType;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}
}