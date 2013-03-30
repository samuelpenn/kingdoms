/*
 * Copyright (C) 2013 Samuel Penn, sam@glendale.org.uk
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation version 3, or
 * any later version. See the file COPYING.
 */
package uk.org.glendale.kingdoms.api

import grails.converters.JSON
import uk.org.glendale.kingdoms.domain.player.Player
import uk.org.glendale.kingdoms.domain.rooms.Room

/**
 * Provides AJAX support for getting information about rooms.
 */
class RoomController {
	
	def	roomService

    def index() {
		render "Hello"
	}
	
	/**
	 * Get details on the specified room.
	 */
	def room(int id) {
		Room	room = Room.get(id)
		
		render room as JSON
	}
	
	/**
	 * Get details on all the exists from the specified room.
	 */
	def exits(int id) {
		Room	room = Room.get(id)
		
		List	exits = roomService.getExits(room)
		
		render exits as JSON
	}
	
	def map(int playerId) {
		Player	player = Player.findById(playerId)
		if (player == null) {
			println "Cannot find player ${playerId}"
			return
		}
		
		
		Room	location = player.avatar.room
		
		render roomService.getLocationMap(location) as JSON
	}
}
