/*
 * Copyright (C) 2013 Samuel Penn, sam@glendale.org.uk
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation version 3, or
 * any later version. See the file COPYING.
 */
package uk.org.glendale.kingdoms.domain.player

import uk.org.glendale.kingdoms.domain.rooms.Room

class Player {
	String			name		// Who are they?
	User			user		// Login details.
	PlayerStatus	status		// What are they doing?
	Avatar			avatar		// Where are they?
	long			last		// When did they last do anything?
	long			refresh     // When action points last refreshed?
	
	int				strength
	int				toughness
	int				health
	int				reflexes
	int				will
	
	int				maxAction
	int				maxHitpoints
	
    static constraints = {
    }
}
