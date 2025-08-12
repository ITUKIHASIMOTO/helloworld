import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class OrderProcessorTest {
	private OrderProcessor processor;
	private boolean premium1;
	private boolean premium2;
	private String prefecture1;
	private String prefecture2;

	@BeforeEach
	void setUp() {
		// テストごとに新しいインスタンスを準備
		processor = new OrderProcessor();
		premium1 = false; // 一般会員
		premium2 = true; // プレミアム会員
		prefecture1 = "東京都";
		prefecture2 = "北海道";
	}

	@Test
	void testRegularCustomerWithSmallOrderInTokyo() {
		// 通常顧客が東京で3000円の注文を行うケース
		double finalPrice = processor.calculateFinalPrice(3000, premium1, prefecture1);

		// 3000円 + 送料300円 = 3300円になるはず
		assertEquals(3300, finalPrice, "通常顧客の小額注文（東京）の計算が正しくありません");
	}

	@Test
	void testPremiumCustomerWithLargeOrderInHokkaido() {
		// プレミアム顧客が北海道で10000円の注文を行うケース
		double finalPrice = processor.calculateFinalPrice(10000, premium2, prefecture2);

		// 10000円 - 5%割引 = 9500円
		// 9500円 - 10%割引 = 8550円
		// 8550円 + 送料500円 = 9050円になるはず
		assertEquals(9050, finalPrice, "プレミアム顧客の大口注文（北海道）の計算が正しくありません");
	}
}
