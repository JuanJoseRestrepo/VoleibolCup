package testers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.notFoundCompetitor;
import exceptions.notFoundPersonError;
import exceptions.notRepeatPerson;
import model.*;

class worldCupTest {

	private worldCup cups;
		
	private void setupEscenario() {
		cups = new worldCup("");
		Competitor e = new Competitor("a","a","a","a","a","a","a","a");
		Competitor e1 = new Competitor("b","b","b","b","b","b","b","b");
		Competitor e2 = new Competitor("c","c","c","c","c","c","c","c");
		Competitor e3 = new Competitor("d","d","d","d","d","d","d","d");
		cups.addCompetitorOrdenate(e);
		cups.addCompetitorOrdenate(e1);
		cups.addCompetitorOrdenate(e2);
		cups.addCompetitorOrdenate(e3);
	}
	
	private void setupEscenario1() {
		cups = new worldCup("");
		Spectator e = new Spectator("a","a","a","a","a","a","a","a");
		Spectator e1 = new Spectator("b","b","b","b","b","b","b","b");
		Spectator e2 = new Spectator("c","c","c","c","c","c","c","c");
		Spectator e3 = new Spectator("d","d","d","d","d","d","d","d");
		try {
			cups.addSpectatorUser(e);
			cups.addSpectatorUser(e1);
			cups.addSpectatorUser(e2);
			cups.addSpectatorUser(e3);
		} catch (notRepeatPerson e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
	}
	
	@Test
	void testFoundCompetitor() throws notFoundCompetitor {
		setupEscenario();
		assertEquals("b",cups.searchCompetitor("b"));
	}
	
	@Test
	void testFoundSpectator() throws notFoundPersonError {
		setupEscenario1();
		assertEquals(cups.searchSpectator2("b"), cups.searchSpectator1("b").toString());
	}
	
	@Test
	void addSpectator() throws notFoundPersonError, notRepeatPerson {
		setupEscenario1();
		Spectator e3 = new Spectator("e","d","d","d","d","d","d","d");
		cups.addSpectatorUser(e3);
		assertEquals(cups.searchSpectator2("e"), cups.searchSpectator1("e").toString());
	}
	
	@Test
	void addCompetitor() {
	    setupEscenario();
	    Competitor e3 = new Competitor("e","d","d","d","d","d","d","d");
	    cups.addCompetitorOrdenate(e3);
	    
	    assertEquals("e", cups.searchCompetitor("e"));
	}
}
