package baseball;

import org.assertj.core.api.Assertions.*;
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
		game.question = "123";
		GuessResult result = game.guess("123");

		assertThat(result).isNotNull();
		assertThat(result.isSolved()).isEqualTo(true);
		assertThat(result.getStrikes()).isEqualTo(3);
		assertThat(result.getBalls()).isEqualTo(0);
	}
	
	@Test
	public void 숫자_세개가_전부_일치_하지_않을_경우_0_strike_0_ball() {
		game.question = "123";
		GuessResult result = game.guess("456");

		assertThat(result).isNotNull();
		assertThat(result.isSolved()).isEqualTo(false);
		assertThat(result.getStrikes()).isEqualTo(0);
		assertThat(result.getBalls()).isEqualTo(0);
	}
	
	@Test
	public void 스트라이크만_있을_경우_1_strike_0_ball() {

	}
	
	@Test
	public void 볼만_있을_경우_0_strike_1_ball() {

	}
	
	@Test
	public void 볼과_스트라이크가_함께_있을_경우_1_strike_1_ball() {

	}
}
