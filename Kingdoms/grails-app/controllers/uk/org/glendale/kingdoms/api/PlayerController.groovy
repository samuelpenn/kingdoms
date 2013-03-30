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
import uk.org.glendale.kingdoms.domain.player.MoveType
import uk.org.glendale.kingdoms.domain.player.Player
import uk.org.glendale.kingdoms.domain.rooms.Room

/**
 * Actions which can be performed on a player. Everyone takes a player id (id)
 * as a path argument.
 */
class PlayerController {
	def roomService
	def playerService

	/**
	 * Describe the current location to the player. Includes the visible map
	 * plus a list of exits.
	 * 
	 * @param id	Id of the player.
	 * @return		Map object describing the location.
	 */
    def look(int id) { 
		Player	player = Player.findById(id)
		if (player == null) {
			println "Cannot find player ${id}"
			return
		}
		
		
		Room	location = player.avatar.room
		
		def     look = [:]
		look.map = roomService.getLocationMap(location)
		look.exits = roomService.getExits(location).keySet()
		
		render look as JSON
	}
	
	/**
	 * Move the player in the specified direction.
	 * On success, returns Look object.
	 * 
	 * @param id		Id of the player.
	 * @param direction	Direction to move in.
	 */
	def move(int id, String direction, String move) {
		Player		player = Player.findById(id)
		MoveType	how = MoveType.WALK
		
		playerService.move(player, direction, how) 
		
		look(id)
	}
}
