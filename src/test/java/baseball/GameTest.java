package baseball;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

	@Test
	public void 게임이_시작가능(){
		Game game = new Game();
		assertNotNull(game);
	}

	@Test
	public void 입력값이_없을_경우() {
		assertThrows(IllegalArgumentException.class, ()->{
			Game game = new Game();
			game.guess(null);
		});
	}
	
	@Test
	public void 입력값_자리수가_세자리가_아닐_경우() {

	}
	
	@Test
	public void 입력값에_숫자_외의_뮸자가_입력될_경우() {

	}
	
	@Test
	public void 입력값에_중복된_숫자가_입력될_경우() {

	}
	
	@Test
	public void 숫자_세개가_전부_일치_할_경우_3_strike() {

	}
	
	@Test
	public void 숫자_세개가_전부_일치_하지_않을_경우_0_strike_0_ball() {

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
