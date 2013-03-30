/*
 * Copyright (C) 2013 Samuel Penn, sam@glendale.org.uk
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation version 3, or
 * any later version. See the file COPYING.
 */
package uk.org.glendale.kingdoms.ui

import uk.org.glendale.kingdoms.domain.player.Player

/**
 * Main game controller.
 */
class GameController {
	
	def roomService

	/**
	 * Setup the model for the game screen.
	 */
	def index() {
		Player		player = Player.findById(1)
		
		render(view: "/game/index.gsp", model: [player: player])
	}
}
