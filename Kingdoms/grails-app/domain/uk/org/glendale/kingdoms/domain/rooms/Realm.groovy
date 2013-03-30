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
 * A Realm is an area which can contain rooms which all exist in the
 * same X-Y-Z coordinate space. Realm 0 is considered to be the default
 * world.
 */
class Realm {
	String		title

    static constraints = {
    }
}
