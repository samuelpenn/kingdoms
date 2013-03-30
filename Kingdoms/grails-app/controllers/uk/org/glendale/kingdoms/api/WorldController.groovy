/*
 * Copyright (C) 2013 Samuel Penn, sam@glendale.org.uk
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation version 3, or
 * any later version. See the file COPYING.
 */
package uk.org.glendale.kingdoms.api

import uk.org.glendale.kingdoms.domain.rooms.Realm
import uk.org.glendale.kingdoms.domain.rooms.Room
import uk.org.glendale.kingdoms.domain.rooms.Terrain

class WorldController {
	
	def roomService
	
	int d(int die) {
		return (int) (Math.random() * die) + 1
	}
	
	private String getRandom(List list) {
		return list[d(list.size()) - 1]
	}

	/**
	 * Create a random outside area.
	 */
    def createSquare(int x, int y, int w, int h) { 
		if (w < 1 || h < 1) {
			render "Too small an area"
			return
		}
		if (x % 1000 != 0 || y % 1000 != 0) {
			render "X and Y must be km aligned"
			return
		}
		
		Realm	realm = Realm.findById(1)
		List terrains = [ "Plains", "Plains", "Plains", "Woodland", "Woodland", "Hills", "Hills", "Lake" ]
		
		for (int py = y; py < y + h * 1000; py += 1000) {
			for (int px = x; px < w * 1000; px += 1000) {
				println px + ", " + py
				
				if (roomService.getRoomByLocation(realm, 1000, px, py, 0) == null) {
					Terrain terrain = Terrain.findByName(getRandom(terrains))
					Room room = new Room()
					room.title = terrain.name
					room.realm = realm
					room.terrain = terrain
					room.x = px
					room.y = py
					room.z = 0
					room.scale = 1000
					
					room.save()
					
				}
			}
		}
		
		render "Done"
	}
}
