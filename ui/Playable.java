package ui;

import scoring.Scorable;

/**
 * @author - Sara Wille
 * Playable is implemented by YahtzeeRules and PigRules.
 */
public interface Playable {

	void play(Scorable myScore);

}
