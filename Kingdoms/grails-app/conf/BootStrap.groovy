import grails.converters.JSON

import uk.org.glendale.kingdoms.domain.rooms.*

class BootStrap {

    def init = { servletContext ->
		
		JSON.registerObjectMarshaller(Room) {
			def map = [:]
			map['title'] = it.title
			map['image'] = it.terrain.image
			map['scale'] = it.scale
			map['realm'] = it.realm.title
			
			return map
		}
		
    }
    def destroy = {
    }
}
