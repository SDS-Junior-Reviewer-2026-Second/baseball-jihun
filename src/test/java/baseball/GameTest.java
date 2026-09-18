package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

	private Game game;

	@BeforeEach
	void setUp() {
		game = new Game();
	}

	@Test
	public void 게임이_시작가능(){
		assertNotNull(game);
	}

	@Test
	public void 입력값이_허용되지_않는_경우() {
		AssertIllegalArgument(null);
		AssertIllegalArgument("12");
		AssertIllegalArgument("1234");
		AssertIllegalArgument("12s");
		AssertIllegalArgument("111");
	}

	private void AssertIllegalArgument(String guessNumber) {
		assertThrows(IllegalArgumentException.class, ()->{
			game.guess(guessNumber);
		});
	}
	
	@Test
	public void 숫자_세개가_전부_일치_할_경우_3_strike() {
		generateQuestion("123");
		assertMatchNumber(game.guess("123"), true, 3, 0);
	}

	@Test
	public void 숫자_세개가_전부_일치_하지_않을_경우_0_strike_0_ball() {
		generateQuestion("123");
		assertMatchNumber(game.guess("456"), false, 0, 0);
	}

	private void generateQuestion(String questionNumber) {
		game.question = questionNumber;
	}

	@Test
	public void 스트라이크만_있을_경우_1_strike_0_ball() {
		generateQuestion("123");
		assertMatchNumber(game.guess("178"),false, 1, 0);
	}

	@Test
	public void 볼만_있을_경우_0_strike_1_ball() {
		generateQuestion("123");
		assertMatchNumber(game.guess("718"),false, 0, 1);
	}

	@Test
	public void 볼과_스트라이크가_함께_있을_경우_1_strike_1_ball() {
		generateQuestion("123");
		assertMatchNumber(game.guess("713"),false, 1, 1);
	}

	private static void assertMatchNumber(GuessResult result, boolean solved, int strikes, int balls) {
		assertThat(result).isNotNull();
		assertThat(result.isSolved()).isEqualTo(solved);
		assertThat(result.getStrikes()).isEqualTo(strikes);
		assertThat(result.getBalls()).isEqualTo(balls);
	}
}
