package ohtuesimerkki;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

public class StatisticsTest {

	Reader readerStub = new Reader() {
		public List<Player> getPlayers() {
			ArrayList<Player> players = new ArrayList<Player>();
			
			players.add(new Player("Semenko", "EDM", 4, 12));
			players.add(new Player("Lemieux", "PIT", 45, 54));
			players.add(new Player("Kurri", "EDM", 37, 53));
			players.add(new Player("Yzerman", "DET", 42, 56));
			players.add(new Player("Gretzky", "EDM", 35, 89));

			return players;
		}
	};

	Statistics stats;

	@Before
	public void setUp() {
		stats = new Statistics(readerStub);
	}

	@Test
	public void PlayerSearchToimii() {
		Player p = stats.search("Semenko");
		assertEquals("Semenko", p.getName());
	}

	@Test
	public void PlayerSearchToimiiJosPelaajaaEiOle() {
		Player p = stats.search("Banaanijeesus");
		assertEquals(null, p);
	}

	@Test
	public void teamSearchToimii() {
		List<Player> t = stats.team("EDM");
		assertEquals(3, t.size());
	}
	
	@Test
	public void topScorersToimii() {
		List<Player> t = stats.topScorers(1);
		assertEquals("Gretzky", t.get(0).getName());
	}
}
