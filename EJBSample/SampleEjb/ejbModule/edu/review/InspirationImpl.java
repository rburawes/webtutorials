package edu.review;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class InspirationImpl
 */
@Stateless
@LocalBean
public class InspirationImpl implements Inspiration {

	private static final String[] qoutes = {

	"Be yourself; everyone else is already taken.",
	"Don't cry because it's over, smile because it happened.",
	"Whatever you are, be a good one."

	};

	public InspirationImpl() {
	}

	public String sendQoutes() {
		return qoutes[(int) (Math.random() * qoutes.length)];
	}

}
