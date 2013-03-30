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
 * A Room is a location within the world. It has a name, and may have exits.
 * All rooms are placed in an X-Y-Z coordinate space, and have a scale.
 * 
 * Each room will have a number of assumed exits, in the directions of North,
 * South, East and West. If there is another Room in the same Realm 'scale'
 * distance in these directions, then such an exit is automatically available.
 */
class Room {
	String		title
	Terrain		terrain // Terrain type for this room.
	Realm		realm
	int			x
	int			y
	int			z
	int			scale	// Scale, normally 1 for indoors or 1000 for outdoors.
	long		last	// Last time something happened in this room.

    static constraints = {
    }
}
