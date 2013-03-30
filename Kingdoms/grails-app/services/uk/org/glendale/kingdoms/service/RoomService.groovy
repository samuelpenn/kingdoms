/*
 * Copyright (C) 2013 Samuel Penn, sam@glendale.org.uk
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation version 3, or
 * any later version. See the file COPYING.
 */
package uk.org.glendale.kingdoms.service

import uk.org.glendale.kingdoms.domain.rooms.Exit
import uk.org.glendale.kingdoms.domain.rooms.Realm
import uk.org.glendale.kingdoms.domain.rooms.Room

class RoomService {

    def serviceMethod() {

    }
	
	/**
	 * Gets the room at a particular coordinate location.
	 */
	def Room getRoomByLocation(Realm realm, int scale, int x, int y, int z) {
		return Room.find ({
			eq('realm', realm)
			eq('scale', scale)
			eq('x', x)
			eq('y', y)
			eq('z', z)
		})
	}
	
	/**
	 * Get a list of all the Exits from this room.
	 * Currently, we only include automatically generated exits.
	 */
	def Map getExits(Room room) {
		Map	exits = [:]
		
		int		scale = room.scale
		
		/*
		// North
		exits.add(getRoomByLocation(room.realm, room.scale, room.x, room.y + room.scale, room.z))
		// South
		exits.add(getRoomByLocation(room.realm, room.scale, room.x, room.y - room.scale, room.z))
		// East
		exits.add(getRoomByLocation(room.realm, room.scale, room.x + room.scale, room.y, room.z))
		// west
		exits.add(getRoomByLocation(room.realm, room.scale, room.x - room.scale, room.y, room.z))
		*/
		Room	r
		
		// North
		r = getRoomByLocation(room.realm, room.scale, room.x, room.y + room.scale, room.z)
		if (r != null) {
			exits.put("n", r)
		}
		// South
		r = getRoomByLocation(room.realm, room.scale, room.x, room.y - room.scale, room.z)
		if (r != null) {
			exits.put("s", r)
		}
		// East
		r = getRoomByLocation(room.realm, room.scale, room.x + room.scale, room.y, room.z)
		if (r != null) {
			exits.put("e", r)
		}
		// West
		r = getRoomByLocation(room.realm, room.scale, room.x - room.scale, room.y, room.z)
		if (r != null) {
			exits.put("w", r)
		}
		
		return exits
	}
	
	/**
	 * Gets a map of the location immediately around this room. Assumes
	 * that this is a normal scale map.
	 */
	def Map getLocationMap(Room room) {
		Map		map = new HashMap()
		
		map.put("origin", room)
		
		List l = [ [ label: "nw", x: -1, y: +1 ], [ label: "n", x: 0, y: +1 ], [ label: "ne", x: +1, y: +1 ],
				   [ label: "w", x: -1, y: 0 ], [ label: "e", x: +1, y: 0 ],
				   [ label: "sw", x: -1, y: -1 ], [ label: "s", x: 0, y: -1 ], [ label: "se", x: 0, y: -1 ] ]
		
		l.each() { p -> 
			String	label = p.label
			int		x = room.x + p.x * room.scale
			int		y = room.y + p.y * room.scale
			
			println "${x},${y}"
			
			Room r = getRoomByLocation(room.realm, room.scale, x, y, room.z)
			if (r != null) {
				map.put(label, r)
			}
		}
		
		return map
	}
}
