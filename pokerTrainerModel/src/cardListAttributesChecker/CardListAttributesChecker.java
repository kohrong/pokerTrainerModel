package cardListAttributesChecker;

import java.util.ArrayList;

import pokertrainer.Card;


public interface CardListAttributesChecker {
	public abstract boolean check(ArrayList<Card> sequence, int target);
}
