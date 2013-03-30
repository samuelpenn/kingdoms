package uk.org.glendale.kingdoms.ui

import uk.org.glendale.kingdoms.domain.rooms.Terrain
import uk.org.glendale.kingdoms.domain.rooms.Room

class TestController {

    def index() { 
		Terrain		t  = Terrain.get(1)
		
		render t.name
		
		List rooms = Room.getAll()
		
		render rooms
	}
}
