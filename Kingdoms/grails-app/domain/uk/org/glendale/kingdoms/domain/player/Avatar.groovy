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

/**
 * An Avatar represents where a creature actually is in the world, and also
 * is what items and other in-world objects attach to. We use a level of
 * abstraction so that Players and Monsters can both refer to it, rather
 * than messing around with super classes in GORM.
 */
class Avatar {
	Room		room
	
	int			hitpoints
	int			actions

    static constraints = {
    }
}
