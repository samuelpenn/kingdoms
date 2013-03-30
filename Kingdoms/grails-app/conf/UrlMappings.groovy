class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')
		
        "/api/room/$id" {
                controller = "room"
                action = "room"
        }
        "/api/room/$id/exits" {
                controller = "room"
                action = "exits"
        }
		
		/**
		 * Player controller actions.
		 */
		"/api/player/$id/look" {
			controller = "player"
			action = "look"
		}

		"/api/player/$id/move/$direction" {
			controller = "player"
			action = "move"
		}

		"/api/world/createSquare" {
			controller = "world"
			action = "createSquare"
		}
	}
}
