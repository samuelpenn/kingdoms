/*
 * Copyright (C) 2013 Samuel Penn, sam@glendale.org.uk
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation version 3, or
 * any later version. See the file COPYING.
 */
package uk.org.glendale.kingdoms.service

import uk.org.glendale.kingdoms.domain.player.MoveType
import uk.org.glendale.kingdoms.domain.player.Player
import uk.org.glendale.kingdoms.domain.rooms.Room

class PlayerService {
	def roomService

    def move(Player player, String direction, MoveType move) {
		Room		location = player.avatar.room

		def	exits = roomService.getExits(location)
		if (exits.get(direction) != null) {
			Room destination = exits.get(direction)
			player.avatar.room = destination
			player.save()
		}

    }
}
