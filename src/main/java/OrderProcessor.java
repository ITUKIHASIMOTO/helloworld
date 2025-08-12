
public class OrderProcessor {
	// 注文を処理して割引を適用する
	public double calculateFinalPrice(double price, boolean premium, String prefecture) {

		// 5000円以上で5%割引
		if (price >= 5000) {
			price = price * 0.95;
		}

		// プレミアム会員はさらに10%割引
		if (premium) {
			price = price * 0.9;
		}

		// 送料追加（北海道・沖縄は追加送料）
		if ("北海道".equals(prefecture) || "沖縄県".equals(prefecture)) {
			price += 500;
		} else {
			price += 300;
		}

		return price;
	}
}
