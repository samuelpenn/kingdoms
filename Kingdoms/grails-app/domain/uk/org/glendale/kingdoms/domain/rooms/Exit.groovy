/*
 * Copyright (C) 2013 Samuel Penn, sam@glendale.org.uk
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation version 3, or
 * any later version. See the file COPYING.
 */
package uk.org.glendale.kingdoms.domain.rooms

/**
 * An exit leads from one room to another.
 */
class Exit {
	Room		room
	Room		destination
	String		title

    static constraints = {
    }
}
